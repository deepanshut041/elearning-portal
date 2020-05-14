package io.github.deepanshut041.swadhyay.auth

import com.fasterxml.jackson.databind.ObjectMapper
import io.github.deepanshut041.swadhyay.config.AppProperties
import io.jsonwebtoken.*
import io.jsonwebtoken.io.JacksonDeserializer
import io.jsonwebtoken.io.JacksonSerializer
import io.jsonwebtoken.security.SecurityException
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import io.jsonwebtoken.security.Keys
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.GrantedAuthority
import org.springframework.stereotype.Component
import kotlin.collections.LinkedHashMap


@Component
class TokenProvider(private val appProperties: AppProperties, private val objectMapper: ObjectMapper) {

    private val logger = KotlinLogging.logger {}

    private val jwtParser = Jwts.parser()
            .deserializeJsonWith(JacksonDeserializer(objectMapper))
            .setSigningKey(appProperties.auth.tokenSecret)

    fun getUserFromToken(token: String): UserPrincipal {
        val claims = jwtParser.parseClaimsJws(token).body
        return UserPrincipal.create(claims.subject,
                claims["name"] as String,
                claims["email"] as String,
                "",
                claims["enabled"] as Boolean,
                (claims["authorities"] as List<*>).map { (it as LinkedHashMap<*, *>)["authority"] as String }
        )
    }

    fun getUsernameFromToken(token: String): String = jwtParser.parseClaimsJws(token).body.subject

    fun generateToken(user: UserPrincipal): String {
        val claims = mutableMapOf<String, Any>()
        claims["authorities"] = user.authorities
        claims["enabled"] = user.isEnabled
        claims["name"] = user.name
        claims["email"] = user.email
        return doGenerateToken(user, claims)
    }

    fun validateToken(token: String): Boolean {
        try {
            if (!jwtParser.isSigned(token)) return false
            val claims = jwtParser.parseClaimsJws(token).body
            val enabled = claims.getOrDefault("enabled", false) as Boolean
            if (!enabled) {
                logger.error { "Invalid JWT, User ${getUsernameFromToken(token)} is inactive" }
            }
            return enabled
        } catch (ex: SecurityException) {
            logger.error { "Invalid JWT signature" }
            return false
        } catch (ex: MalformedJwtException) {
            logger.error { "Invalid JWT token" }
            return false
        } catch (ex: ExpiredJwtException) {
            logger.error { "Expired JWT token" }
            return false
        } catch (ex: UnsupportedJwtException) {
            logger.error { "Unsupported JWT token" }
            return false
        } catch (ex: IllegalArgumentException) {
            logger.error { "JWT claims string is empty" }
            return false
        }
    }

    private fun doGenerateToken(userPrincipal: UserPrincipal, claims: Map<String, Any>): String {
        val now = Date()
        val expiryDate = Date(now.time + appProperties.auth.tokenExpirationMsec)
        return Jwts.builder()
                .serializeToJsonWith(JacksonSerializer(objectMapper))
                .setClaims(claims)
                .setSubject(userPrincipal.id)
                .setIssuedAt(Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, appProperties.auth.tokenSecret)
                .compact()
    }
}
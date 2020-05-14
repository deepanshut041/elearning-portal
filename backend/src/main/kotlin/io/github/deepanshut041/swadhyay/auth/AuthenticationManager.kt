package io.github.deepanshut041.swadhyay.auth

import io.github.deepanshut041.swadhyay.util.UnauthorizedException
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@Component
class AuthenticationManager(private val tokenProvider: TokenProvider) : ReactiveAuthenticationManager {

    override fun authenticate(authentication: Authentication): Mono<Authentication> {
        val authToken = authentication.credentials.toString()
        return if (tokenProvider.validateToken(authToken)) {
            val user = tokenProvider.getUserFromToken(authToken)
            UsernamePasswordAuthenticationToken(user, null, user.authorities).toMono()

        } else {
            Mono.error(UnauthorizedException("Invalid JWT token"))
        }
    }
}
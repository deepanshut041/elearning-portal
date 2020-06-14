package io.github.deepanshut041.swadhyay.config

import io.github.deepanshut041.swadhyay.auth.AuthenticationManager
import io.github.deepanshut041.swadhyay.auth.SecurityContextRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.server.SecurityWebFilterChain
import reactor.core.publisher.Mono

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
class SecurityConfiguration(
        private val authenticationManager: AuthenticationManager,
        private val securityContextRepository: SecurityContextRepository
) {

    /**
     * The default password encoder, used for encoding password in User Document
     * And used to decode password in Spring security Authentication
     */
    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()

    @Bean
    fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http.cors()
                .and()
                .csrf().disable()
                .formLogin().disable()
                .httpBasic().disable()
                .csrf().disable()
                .logout().disable()
                .exceptionHandling()
                .authenticationEntryPoint { exchange, _ -> Mono.fromRunnable {
                    exchange.response.statusCode = HttpStatus.UNAUTHORIZED
                } }.accessDeniedHandler { exchange, _ -> Mono.fromRunnable {
                    exchange.response.statusCode = HttpStatus.FORBIDDEN
                } }.and()
                .authenticationManager(authenticationManager)
                .securityContextRepository(securityContextRepository)
                .authorizeExchange()
                .pathMatchers(HttpMethod.OPTIONS).permitAll()
                .pathMatchers("/", "/error", "/favicon.ico", "/*/*.png", "/*/*.gif", "/*/*.svg", "/*/*.jpg", "/*/*/*.html", "/*/*.css", "/*/*.js").permitAll()
                .pathMatchers("/v3/api-docs/**", "/v3/api/docs", "/webjars/swagger-ui/**", "/swagger-ui.html").permitAll()
                .pathMatchers("/api/account/**", "/api/home/**").permitAll()
                .pathMatchers("/api/mentor/**").hasRole("MENTOR")
                .pathMatchers("/api/student/**").hasRole("STUDENT")
                .pathMatchers("/api/admin/**").hasRole("ADMIN")
                .anyExchange().authenticated()
                .and().build()!!
    }


}

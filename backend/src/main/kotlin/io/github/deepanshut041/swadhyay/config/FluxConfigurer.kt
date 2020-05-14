package io.github.deepanshut041.swadhyay.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.ResourceHandlerRegistry
import org.springframework.web.reactive.config.WebFluxConfigurer


@Configuration
class FluxConfigurer: WebFluxConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
    }


    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
                .components(Components().addSecuritySchemes("bearerAuth",
                        SecurityScheme().apply {
                            name = "bearerAuth"
                            type = SecurityScheme.Type.HTTP
                            bearerFormat = "JWT"
                            scheme = "bearer"
                        }))
                .info(Info().title("Swadhyay API").version("1.0.0").license(
                        License().name("Apache 2.0").url("http://swadhyay.squrlabs.com")))
    }
}
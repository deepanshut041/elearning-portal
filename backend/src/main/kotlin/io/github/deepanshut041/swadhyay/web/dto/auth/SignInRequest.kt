package io.github.deepanshut041.swadhyay.web.dto.auth

import javax.validation.constraints.*

data class SignInRequest(
        @field:Email @field:Max(50) @field:NotEmpty val email: String,
        @field:Min(8) @field:Max(20) @field:NotEmpty val password: String
)
package io.github.deepanshut041.swadhyay.web.dto.account

import javax.validation.constraints.*

data class SignInRequest(
        @field:Email @field:NotEmpty val email: String,
        @field:Size(min = 8, max = 20) @field:NotEmpty val password: String
)
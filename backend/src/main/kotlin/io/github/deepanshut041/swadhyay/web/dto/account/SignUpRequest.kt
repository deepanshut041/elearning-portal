package io.github.deepanshut041.swadhyay.web.dto.account

import javax.validation.constraints.*

data class SignUpRequest(
        @field:NotEmpty val name:String,
        @field:Email @field:NotEmpty val email:String,
        @field:NotEmpty @field:Size(min = 8, max = 20) val password: String
)
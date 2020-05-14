package io.github.deepanshut041.swadhyay.web.dto.account

import javax.validation.constraints.NotEmpty

data class ProfileRequest(
        @field:NotEmpty val name: String,
        @field:NotEmpty val about: String,
        @field:NotEmpty val avatar: String
)
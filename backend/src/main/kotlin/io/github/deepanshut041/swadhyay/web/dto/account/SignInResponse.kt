package io.github.deepanshut041.swadhyay.web.dto.account

data class SignInResponse (val token: String, val tokenType: String = "Bearer ")
package io.github.deepanshut041.swadhyay.web.dto.auth

data class SignInResponse (val token: String, val tokenType: String = "Bearer ")
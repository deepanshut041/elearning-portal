package io.github.deepanshut041.swadhyay.auth

import org.springframework.security.core.GrantedAuthority

enum class Role : GrantedAuthority {
    ROLE_ADMIN,
    ROLE_STUDENT,
    ROLE_MENTOR;

    override fun getAuthority() = this.name
}
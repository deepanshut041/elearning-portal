package io.github.deepanshut041.swadhyay.auth

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

data class UserPrincipal(
        val id: String, val name: String, val email: String, var mPassword: String,
        val active: Boolean, val roles: Collection<GrantedAuthority?>
): UserDetails{

    override fun getAuthorities(): Collection<GrantedAuthority?> = roles

    override fun isEnabled() = active

    override fun getUsername() = email

    override fun isCredentialsNonExpired() = true

    override fun getPassword() = mPassword

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = active

    companion object {

        fun create(id: String, name: String, email: String, password: String, active: Boolean, roles: List<String>) =
                UserPrincipal(id, name, email, password, active, rolesToAuthority(roles))

        private fun rolesToAuthority(roles: List<String>): Collection<GrantedAuthority>{
            val authorises = ArrayList<GrantedAuthority>()

            roles.map {
                authorises.add(SimpleGrantedAuthority(it))
            }
            return authorises
        }
    }
}
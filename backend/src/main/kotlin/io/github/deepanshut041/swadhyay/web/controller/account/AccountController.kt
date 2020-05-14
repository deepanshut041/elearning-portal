package io.github.deepanshut041.swadhyay.web.controller.account

import io.github.deepanshut041.swadhyay.auth.UserPrincipal
import io.github.deepanshut041.swadhyay.services.UserService
import io.github.deepanshut041.swadhyay.web.dto.account.ProfileRequest
import io.github.deepanshut041.swadhyay.web.dto.account.SignInRequest
import io.github.deepanshut041.swadhyay.web.dto.account.SignInResponse
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactor.mono
import org.springframework.http.ResponseEntity
import org.springframework.security.access.annotation.Secured
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.context.ReactiveSecurityContextHolder
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(AccountController.ACCOUNT_BASE_URI, consumes = ["application/json"])
@Tag(name = "Account API", description = "This contains routes regarding user account")
class AccountController(private val userService: UserService) {

    @PostMapping("/signin")
    fun signIn(@Valid @RequestBody signInRequest: SignInRequest) = mono {
        ResponseEntity.ok(SignInResponse(userService.authenticate(signInRequest)))
    }

    @GetMapping("/profile")
    @Secured()
    @SecurityRequirement(name = "bearerAuth")
    fun getProfile() = mono {
        val user = ReactiveSecurityContextHolder.getContext().map { it.authentication.principal as UserPrincipal }.awaitFirst()
        ResponseEntity.ok(userService.getProfile(user.id))
    }

    @PutMapping("/profile")
    @Secured()
    @SecurityRequirement(name = "bearerAuth")
    fun updateProfile(@Valid @RequestBody profileRequest: ProfileRequest) = mono {
        val user = ReactiveSecurityContextHolder.getContext().map { it.authentication.principal as UserPrincipal }.awaitFirst()
        ResponseEntity.ok(userService.updateProfile(user.id, profileRequest))
    }

    companion object {
        const val ACCOUNT_BASE_URI = "/api/account"
    }
}
package io.github.deepanshut041.swadhyay.web.controller.account

import io.github.deepanshut041.swadhyay.auth.Role
import io.github.deepanshut041.swadhyay.auth.UserPrincipal
import io.github.deepanshut041.swadhyay.services.UserService
import io.github.deepanshut041.swadhyay.web.dto.APIResponse
import io.github.deepanshut041.swadhyay.web.dto.account.SignInRequest
import io.github.deepanshut041.swadhyay.web.dto.account.SignInResponse
import io.github.deepanshut041.swadhyay.web.dto.account.SignUpRequest
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactor.mono
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity.ok
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.context.ReactiveSecurityContextHolder
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(StudentAccountController.AUTH_BASE_URI, consumes = ["application/json"])
@Tag(name = "Student Account API", description = "This contains routes regarding student account")
class StudentAccountController(@Autowired val userService: UserService) {

    @PostMapping("/signin")
    fun signIn(@Valid @RequestBody signInRequest: SignInRequest) = mono {
        ok(SignInResponse(userService.authenticate(signInRequest)))
    }

    @PostMapping("/signup")
    suspend fun signUp(@Valid @RequestBody signUpRequest: SignUpRequest) = mono {
        userService.save(signUpRequest , listOf(Role.ROLE_STUDENT.name))
        ok(APIResponse("Successfully registered user"))
    }

    @GetMapping("/profile")
    @PreAuthorize("hasRole('STUDENT')")
    @SecurityRequirement(name = "bearerAuth")
    fun profile() = mono {
        val user = ReactiveSecurityContextHolder.getContext().map { it.authentication.principal as UserPrincipal }.awaitFirst()
        ok(userService.profile(user.id))
    }

    companion object {
        const val AUTH_BASE_URI = "/api/account/student"
    }
}
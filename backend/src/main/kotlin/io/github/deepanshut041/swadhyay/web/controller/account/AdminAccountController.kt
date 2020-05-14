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
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity.ok
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.context.ReactiveSecurityContextHolder
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(AdminAccountController.AUTH_BASE_URI, produces = [MediaType.APPLICATION_JSON_VALUE])
@Tag(name = "Account API", description = "This contains routes regarding user account")
class AdminAccountController(
        @Autowired val userService: UserService
) {

    @PostMapping("/signup")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    fun signUp(@Valid @RequestBody signUpRequest: SignUpRequest) = mono {
        userService.save( signUpRequest, listOf(Role.ROLE_MENTOR.name, Role.ROLE_STUDENT.name, Role.ROLE_ADMIN.name))
        ok(APIResponse("Successfully registered user"))
    }

    @PatchMapping("/enroll/mentor")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    fun enrollAsMentor(@RequestParam("id", required = true)id: String) = mono {
        userService.addRole(id, Role.ROLE_MENTOR.name)
        ok(APIResponse("Successfully enrolled as mentor"))
    }

    @PatchMapping("/enroll/admin")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    fun enrollAsAdmin(@RequestParam("id", required = true)id: String) = mono {
        userService.addRole(id, Role.ROLE_ADMIN.name)
        ok(APIResponse("Successfully enrolled as admin"))
    }

    @PatchMapping("/resign/mentor")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    fun resignAsMentor(@RequestParam("id", required = true)id: String) = mono {
        userService.removeRole(id, Role.ROLE_MENTOR.name)
        ok(APIResponse("Successfully resigned as mentor"))
    }

    @PatchMapping("/resign/admin")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    fun resignAsAdmin(@RequestParam("id", required = true)id: String) = mono {
        userService.removeRole(id, Role.ROLE_ADMIN.name)
        ok(APIResponse("Successfully resigned as admin"))
    }


    companion object {
        const val AUTH_BASE_URI = "/api/account/admin"
    }
}
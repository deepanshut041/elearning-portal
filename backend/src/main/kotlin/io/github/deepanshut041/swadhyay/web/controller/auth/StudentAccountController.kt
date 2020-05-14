package io.github.deepanshut041.swadhyay.web.controller.auth

import io.github.deepanshut041.swadhyay.services.UserService
import io.github.deepanshut041.swadhyay.web.dto.APIResponse
import io.github.deepanshut041.swadhyay.web.dto.auth.SignInRequest
import io.github.deepanshut041.swadhyay.web.dto.auth.SignInResponse
import io.github.deepanshut041.swadhyay.web.dto.auth.SignUpRequest
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import javax.validation.Valid

@RestController
@RequestMapping(StudentAccountController.AUTH_BASE_URI, consumes = ["application/json"])
@Tag(name = "Student Account API", description = "This contains routes regarding student account")
class StudentAccountController(
        @Autowired val userService: UserService
) {

    @PostMapping("/signin")
    suspend fun signIn(@Valid @RequestBody signInRequest: SignInRequest): SignInResponse {
        return SignInResponse(userService.authenticate(signInRequest))
    }

    @PostMapping("/signup")
    suspend fun signUp(@Valid @RequestBody signUpRequest: SignUpRequest): APIResponse {
        userService.save(signUpRequest)
        return APIResponse("Successfully registered user")
    }

    companion object {
        const val AUTH_BASE_URI = "/api/account/student"
    }
}
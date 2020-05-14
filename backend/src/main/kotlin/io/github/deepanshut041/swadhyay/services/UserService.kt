package io.github.deepanshut041.swadhyay.services

import io.github.deepanshut041.swadhyay.auth.Role
import io.github.deepanshut041.swadhyay.auth.TokenProvider
import io.github.deepanshut041.swadhyay.auth.UserPrincipal
import io.github.deepanshut041.swadhyay.data.entity.UserEntity
import io.github.deepanshut041.swadhyay.data.repository.UserRepository
import io.github.deepanshut041.swadhyay.util.BadRequestException
import io.github.deepanshut041.swadhyay.util.UnauthorizedException
import io.github.deepanshut041.swadhyay.web.dto.auth.SignInRequest
import io.github.deepanshut041.swadhyay.web.dto.auth.SignUpRequest
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service("userService")
class UserServiceImpl(
        private val userRepository: UserRepository,
        private val tokenProvider: TokenProvider,
        private val passwordEncoder: PasswordEncoder
) : UserService {

    @Throws(UnauthorizedException::class)
    override suspend fun authenticate(signInRequest: SignInRequest): String {
        val user = userRepository.findByEmail(signInRequest.email).awaitFirstOrNull()
        user?.let {
            if (passwordEncoder.matches(signInRequest.password, it.password))
                return tokenProvider.generateToken(UserPrincipal.create(it.id!!, it.name, it.email, it.password, it.active, it.roles))
            else
                throw UnauthorizedException("You have entered an invalid email or password")
        } ?: run {
            throw UnauthorizedException("You have entered an invalid email or password")
        }
    }

    @Throws(BadRequestException::class)
    override suspend fun save(req: SignUpRequest): UserEntity {
        val user = userRepository.findByEmail(req.email).awaitFirstOrNull()
        user?.let {
            throw BadRequestException("User already exist with ${req.email}")
        } ?: run {
            return userRepository.save(UserEntity(null, req.email, passwordEncoder.encode(req.password),
                    req.name, "", "", true, listOf(Role.ROLE_STUDENT.name), Date(), Date())).awaitFirst()
        }
    }
}


interface UserService {
    suspend fun authenticate(signInRequest: SignInRequest): String
    suspend fun save(req: SignUpRequest): UserEntity
}
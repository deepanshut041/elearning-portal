package io.github.deepanshut041.swadhyay.services

import io.github.deepanshut041.swadhyay.auth.TokenProvider
import io.github.deepanshut041.swadhyay.auth.UserPrincipal
import io.github.deepanshut041.swadhyay.data.entity.UserEntity
import io.github.deepanshut041.swadhyay.data.repository.UserRepository
import io.github.deepanshut041.swadhyay.util.BadRequestException
import io.github.deepanshut041.swadhyay.util.ResourceNotFoundException
import io.github.deepanshut041.swadhyay.util.UnauthorizedException
import io.github.deepanshut041.swadhyay.web.dto.account.ProfileRequest
import io.github.deepanshut041.swadhyay.web.dto.account.ProfileResponse
import io.github.deepanshut041.swadhyay.web.dto.account.SignInRequest
import io.github.deepanshut041.swadhyay.web.dto.account.SignUpRequest
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

    override suspend fun save(req: SignUpRequest, roles: List<String>): UserEntity {
        val user = userRepository.findByEmail(req.email).awaitFirstOrNull()
        user?.let {
            throw BadRequestException("User already exist with ${req.email}")
        } ?: run {
            return userRepository.save(UserEntity(null, req.email, passwordEncoder.encode(req.password),
                    req.name, "", "", true, roles, Date(), Date())).awaitFirst()
        }
    }

    override suspend fun getProfile(id: String): ProfileResponse {
        val user = userRepository.findById(id).awaitFirstOrNull()
        user?.let {
            return ProfileResponse(it.id!!, it.name, it.about, it.avatar)
        } ?: run {
            throw ResourceNotFoundException("User", "id", id)
        }
    }

    override suspend fun updateProfile(id: String, req: ProfileRequest): ProfileResponse {
        val user = userRepository.findById(id).awaitFirstOrNull()
        user?.let {
            val uUser = userRepository.save(it.copy(name = req.name, about = req.about, avatar = req.avatar)).awaitFirst()
            return ProfileResponse(id = uUser.id!!, name = uUser.name, about = uUser.about, avatar = uUser.avatar)
        } ?: run {
            throw ResourceNotFoundException("User", "id", id)
        }
    }
}


interface UserService {
    suspend fun authenticate(signInRequest: SignInRequest): String
    suspend fun save(req: SignUpRequest, roles: List<String>): UserEntity
    suspend fun getProfile(id: String): ProfileResponse
    suspend fun updateProfile(id: String, req: ProfileRequest): ProfileResponse
}
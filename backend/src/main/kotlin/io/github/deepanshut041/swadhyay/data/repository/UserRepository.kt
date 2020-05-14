package io.github.deepanshut041.swadhyay.data.repository

import io.github.deepanshut041.swadhyay.data.entity.UserEntity
import org.reactivestreams.Publisher
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

interface UserRepository: ReactiveMongoRepository<UserEntity, String> {

    fun findByEmail(email:String): Mono<UserEntity>

}
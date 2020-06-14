package io.github.deepanshut041.swadhyay.data.repository

import io.github.deepanshut041.swadhyay.data.entity.CourseEntity
import io.github.deepanshut041.swadhyay.data.entity.CourseLevel
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface CourseRepository: ReactiveMongoRepository<CourseEntity, String> {
    fun findAllByLevel(level: CourseLevel): Flux<CourseEntity>
    fun findAllByCategory(category: String): Flux<CourseEntity>
    fun findAllByLevelAndCategory(level: CourseLevel, category: String): Flux<CourseEntity>
}
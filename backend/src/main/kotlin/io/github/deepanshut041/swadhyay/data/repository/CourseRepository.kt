package io.github.deepanshut041.swadhyay.data.repository

import io.github.deepanshut041.swadhyay.data.entity.CourseEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository: ReactiveMongoRepository<CourseEntity, String> {
}
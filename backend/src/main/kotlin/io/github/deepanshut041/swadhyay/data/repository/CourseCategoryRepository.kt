package io.github.deepanshut041.swadhyay.data.repository

import io.github.deepanshut041.swadhyay.data.entity.CourseCategoryEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseCategoryRepository: ReactiveMongoRepository<CourseCategoryEntity, String> {
}
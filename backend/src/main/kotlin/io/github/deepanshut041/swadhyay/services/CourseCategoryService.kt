package io.github.deepanshut041.swadhyay.services

import io.github.deepanshut041.swadhyay.data.entity.CourseCategoryEntity
import io.github.deepanshut041.swadhyay.data.repository.CourseCategoryRepository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service("courseCategoryService")
class CourseCategoryServiceImpl(
        private val courseCategoryRepository: CourseCategoryRepository
): CourseCategoryService {

}

interface CourseCategoryService {
}
package io.github.deepanshut041.swadhyay.services

import io.github.deepanshut041.swadhyay.data.entity.CourseEntity
import io.github.deepanshut041.swadhyay.data.repository.CourseRepository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
class CourseServiceImpl(
        private val courseRepository: CourseRepository
): CourseService {

}

interface CourseService {
}
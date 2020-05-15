package io.github.deepanshut041.swadhyay.services

import io.github.deepanshut041.swadhyay.data.entity.CourseProgressEntity
import io.github.deepanshut041.swadhyay.data.repository.CourseProgressRepository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
class CourseProgressServiceImpl(
        private val courseProgressRepository: CourseProgressRepository
): CourseProgressService {

}

interface CourseProgressService {

}
package io.github.deepanshut041.swadhyay.services

import io.github.deepanshut041.swadhyay.data.entity.CourseStepEntity
import io.github.deepanshut041.swadhyay.data.repository.CourseStepRepository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service("courseStepService")
class CourseStepServiceImpl(
        private val courseStepRepository: CourseStepRepository
): CourseStepService {

}

interface CourseStepService {
}
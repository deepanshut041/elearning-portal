package io.github.deepanshut041.swadhyay.services

import io.github.deepanshut041.swadhyay.data.entity.CourseAssignmentEntity
import io.github.deepanshut041.swadhyay.data.repository.CourseAssignmentRepository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service("courseAssignmentService")
class CourseAssignmentServiceImpl(
        private val courseAssignmentRepository: CourseAssignmentRepository
): CourseAssignmentService {

}

interface CourseAssignmentService {
}

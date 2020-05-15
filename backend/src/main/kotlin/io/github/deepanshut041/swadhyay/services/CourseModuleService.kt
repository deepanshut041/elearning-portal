package io.github.deepanshut041.swadhyay.services

import io.github.deepanshut041.swadhyay.data.entity.CourseModuleEntity
import io.github.deepanshut041.swadhyay.data.repository.CourseModuleRepository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service


@Service("courseModuleService")
class CourseModuleServiceImpl(
        private val courseModuleRepository: CourseModuleRepository
): CourseModuleService {

}

interface CourseModuleService {
}
package io.github.deepanshut041.swadhyay.services

import io.github.deepanshut041.swadhyay.data.entity.CourseEntity
import io.github.deepanshut041.swadhyay.data.entity.CourseLevel
import io.github.deepanshut041.swadhyay.data.repository.CourseRepository
import io.github.deepanshut041.swadhyay.util.ResourceNotFoundException
import io.github.deepanshut041.swadhyay.util.valueOf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirstOrElse
import org.springframework.stereotype.Service

@Service
class CourseServiceImpl(
        private val courseRepository: CourseRepository
): CourseService {

    override suspend fun getAllCourses(level: String?, category: String?): Flow<CourseEntity> {
        return when{
            (level != null && category != null) -> courseRepository.findAllByLevelAndCategory(valueOf(level, CourseLevel.BEGINNER), category)
            (level != null && category == null) -> courseRepository.findAllByLevel(valueOf(level, CourseLevel.BEGINNER))
            (level == null && category != null) -> courseRepository.findAllByCategory(category)
            else -> courseRepository.findAll()
        }.asFlow()
    }

    override suspend fun getCourse(id: String): CourseEntity? {
        return courseRepository.findById(id).awaitFirstOrElse {
            throw ResourceNotFoundException("Course", "id", id)
        }
    }
}

interface CourseService {
    suspend fun getAllCourses(level: String?, category: String?): Flow<CourseEntity>
    suspend fun getCourse(id: String): CourseEntity?
}
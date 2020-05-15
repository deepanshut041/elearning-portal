package io.github.deepanshut041.swadhyay.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("course_list")
data class CourseEntity(
        @Id val id: String,
        val title: String,
        val description: String,
        val status: CourseStatus,
        val startDate: Date,
        val trailer: String,
        val level: CourseLevel,
        val language: String,
        val courseLength: Int,
        @Indexed(unique = false) val category: String,
        val creator: String,
        val mentors: List<String>)

enum class CourseStatus{
    ACTIVE, ARCHIVE, ONGOING, CLOSE, UPCOMING
}

enum class CourseLevel {
    NOOB, BEGINNER, INTERMEDIATE, ADVANCED, EXPERT
}

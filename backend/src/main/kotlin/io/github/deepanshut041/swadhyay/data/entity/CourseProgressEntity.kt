package io.github.deepanshut041.swadhyay.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("course_progress")
data class CourseProgressEntity(
        @Id val id: String,
        @Indexed(unique = false) val courseId: String,
        @Indexed(unique = false) val userId: String,
        val certificateUrl: String,
        val completed: Date
)
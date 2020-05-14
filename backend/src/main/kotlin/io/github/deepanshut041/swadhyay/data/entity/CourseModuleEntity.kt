package io.github.deepanshut041.swadhyay.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document("course_modules")
data class CourseModuleEntity(
        @Id val id: String,
        @Indexed(unique = false) val courseId: String,
        val title: String,
        val rank: Int,
        val description: String
        )
package io.github.deepanshut041.swadhyay.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("course_categories")
data class CourseCategoryEntity(
        @Id val id: String,
        val title: String,
        val description: String
)
package io.github.deepanshut041.swadhyay.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document("course_assignments")
data class CourseAssignmentEntity(
        @Id val id: String,
        @Indexed(unique = false) val moduleId: String,
        val title: String,
        val description: String,
        val rank: Int,
        val questions: List<AssignmentQuestion>
)

data class AssignmentQuestion(
        val title: String,
        val answers: List<String>,
        val correctAnswers: List<String>,
        val type: AssignmentQuestionType
)

enum class AssignmentQuestionType { SINGLE, MULTI, INPUT }
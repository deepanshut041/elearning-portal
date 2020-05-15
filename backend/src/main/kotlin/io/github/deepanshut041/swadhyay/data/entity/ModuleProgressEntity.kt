package io.github.deepanshut041.swadhyay.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document("module_progress")
data class ModuleProgressEntity(
        @Id val id: String,
        @Indexed(unique = false) val moduleId: String,
        @Indexed(unique = false) val userId: String,
        @Indexed(unique = false) val courseId: String,
        val steps: Map<String, StepProgress>,
        val assignments: Map<String, AssignmentProgress>
)

data class StepProgress(
        val id: String,
        val stepQuizProgresses: Map<Int, StepQuizProgress>
)

data class StepQuizProgress(
        val id: Int,
        val score: Int
)

data class AssignmentProgress(
    val id: String,
    val questions: Map<Int, AssignmentQuestionProgress>
)

data class AssignmentQuestionProgress(
        val id: String,
        val score: Int
)
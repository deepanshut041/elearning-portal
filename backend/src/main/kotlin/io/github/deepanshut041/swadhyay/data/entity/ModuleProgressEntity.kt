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
        val steps: List<StepProgress>,
        val assignments: List<AssignmentProgress>
)

data class StepProgress(
        val id: String,
        val stepQuizProgresses: List<StepQuizProgress>
)

data class StepQuizProgress(
        val id: Int,
        val score: Int
)

data class AssignmentProgress(
    val id: String,
    val questions: List<AssignmentQuestionProgress>
)

data class AssignmentQuestionProgress(
        val id: String,
        val score: Int
)
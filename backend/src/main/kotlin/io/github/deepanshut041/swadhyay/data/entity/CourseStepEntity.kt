package io.github.deepanshut041.swadhyay.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document("course_steps")
data class CourseStep(
        @Id val id: String,
        @Indexed(unique = false) val courseId: String,
        @Indexed(unique = false) val moduleId: String,
        val title: String,
        val rank: Int,
        val type: StepType,
        val text: String,
        val video: List<StepVideo>,
        val quiz: List<StepQuiz>
)

data class StepVideo(
        val url: String,
        val subtitles: String
)

data class StepQuiz(
        val title: String,
        val questions: List<QuizQuestion>)

data class QuizQuestion(
        val title: String,
        val answers: List<String>,
        val correctAnswers: List<String>,
        val type: QuizQuestionType
)

enum class QuizQuestionType { SINGLE, MULTI, INPUT }

enum class StepType { VIDEO, TEXT }
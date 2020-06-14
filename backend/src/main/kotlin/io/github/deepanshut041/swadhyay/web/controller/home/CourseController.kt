package io.github.deepanshut041.swadhyay.web.controller.home

import io.github.deepanshut041.swadhyay.data.entity.CourseEntity
import io.github.deepanshut041.swadhyay.services.CourseService
import io.github.deepanshut041.swadhyay.web.controller.home.CourseController.Companion.HOME_COURSE_URI
import io.swagger.v3.oas.annotations.tags.Tag
import kotlinx.coroutines.flow.produceIn
import kotlinx.coroutines.reactor.flux
import kotlinx.coroutines.reactor.mono
import org.springframework.data.repository.query.Param
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux

@RestController
@RequestMapping(HOME_COURSE_URI, produces = ["application/json"])
@Tag(name = "Home Course API", description = "This contains routes regarding course for public")
class CourseController(
        private val courseService: CourseService
) {

    @GetMapping
    fun getCourses(
            @RequestParam("level", required = false) level: String?,
            @RequestParam("category", required = false) category: String?
    ): Flux<CourseEntity> = flux {
        courseService.getAllCourses(level, category).produceIn(this)
    }

    @GetMapping("/{id}")
    fun getCourse(@PathVariable("id") id: String) = mono {
        courseService.getCourse(id)
    }

    companion object {
        const val HOME_COURSE_URI = "/api/home/courses"
    }
}
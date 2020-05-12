package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.models.Course;

import java.util.List;

public interface CourseService {

    void addCourse(Course course);

    void updateCourse(Course course);

    void deleteCourseById(int id);

    List<Course> findAllCourses();

    Course getCourseById(int id);

//    List<Course> findCoursesByCategory(int category);
//
//    List<Course> findCoursesByTechLanguage(int tech_language_id);
//
//    List<Course> findCoursesByMentor(int mentor_id);

}

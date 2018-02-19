package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.Course;

import java.util.List;

public interface CourseDao {

    void saveCourse(Course course);
    Course getCourse(int id);
    List<Course> listCourses();
    void updateCourse(Course course);
    void deleteCourse(int id);

}

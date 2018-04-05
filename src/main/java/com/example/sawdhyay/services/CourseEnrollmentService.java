package com.example.sawdhyay.services;

import com.example.sawdhyay.models.CourseEnrollment;

import java.util.List;

public interface CourseEnrollmentService {

    void addCourseEnrollment(CourseEnrollment courseEnrollment);

    void updateCourseEnrollment(CourseEnrollment courseEnrollment);

    void deleteCourseEnrollmentById(int id);

    List<CourseEnrollment> findAllCourseEnrollments();

    CourseEnrollment getCourseEnrollmentById(int id);
    
}

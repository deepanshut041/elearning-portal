package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.CourseEnrollment;

import java.util.List;

public interface CourseEnrollmentDao {
    void saveCourseEnrollment(CourseEnrollment courseEnrollment);
    CourseEnrollment getCourseEnrollment(int id);
    List<CourseEnrollment> listCourseEnrollments();
    void updateCourseEnrollment(CourseEnrollment courseEnrollment);
    void deleteCourseEnrollment(int id);
}

package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.models.Enrollment;

import java.util.List;

public interface EnrollmentService {

    void addEnrollment(Enrollment enrollment);

    void updateEnrollment(Enrollment enrollment);

    void deleteEnrollmentById(int id);

    List<Enrollment> findAllEnrollments();

    Enrollment getEnrollmentById(int id);

    List<Enrollment> findEnrollmentsByStudent(int id);

    Enrollment getEnrollmentsByStudentAndCourse(int student_id, int course_id);
    
}

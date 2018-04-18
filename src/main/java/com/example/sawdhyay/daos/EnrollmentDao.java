package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.Enrollment;

import java.util.List;

public interface EnrollmentDao {
    void saveEnrollment(Enrollment enrollment);
    Enrollment getEnrollment(int id);
    List<Enrollment> listEnrollments();
    List<Enrollment> getEnrollmentsByStudent(int id);
    void updateEnrollment(Enrollment enrollment);
    void deleteEnrollment(int id);
    Enrollment getEnrollmentsByStudentAndCourse(int student_id, int course_id);
}

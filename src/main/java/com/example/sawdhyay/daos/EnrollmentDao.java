package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.Enrollment;

import java.util.List;

public interface EnrollmentDao {
    void saveEnrollment(Enrollment enrollment);
    Enrollment getEnrollment(int id);
    List<Enrollment> listEnrollments();
    void updateEnrollment(Enrollment enrollment);
    void deleteEnrollment(int id);
}

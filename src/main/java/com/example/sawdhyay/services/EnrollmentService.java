package com.example.sawdhyay.services;

import com.example.sawdhyay.models.Enrollment;

import java.util.List;

public interface EnrollmentService {

    void addEnrollment(Enrollment enrollment);

    void updateEnrollment(Enrollment enrollment);

    void deleteEnrollmentById(int id);

    List<Enrollment> findAllEnrollments();

    Enrollment getEnrollmentById(int id);

    List<Enrollment> findEnrollmentsByStudent(int id);
    
}

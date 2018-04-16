package com.example.sawdhyay.services;

import com.example.sawdhyay.models.Student;

import java.util.List;

public interface StudentService {

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudentById(int id);

    List<Student> findAllStudents();

    Student getStudentById(int id);

    Student getStudentByUserId(int id);
    
}

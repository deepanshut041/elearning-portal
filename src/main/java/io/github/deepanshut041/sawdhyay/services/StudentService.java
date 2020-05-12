package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.models.Student;

import java.util.List;

public interface StudentService {

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudentById(int id);

    List<Student> findAllStudents();

    Student getStudentById(int id);

    Student getStudentByUserId(int id);
    
}

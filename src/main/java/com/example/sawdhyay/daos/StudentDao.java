package com.example.sawdhyay.daos;


import com.example.sawdhyay.models.Student;

import java.util.List;

public interface StudentDao {

    void saveStudent(Student student);
    Student getStudent(int id);
    List<Student> listStudents();
    void updateStudent(Student student);
    void deleteStudent(int id);

    Student getStudentByUserId(int id);

}

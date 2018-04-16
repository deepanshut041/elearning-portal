package com.example.sawdhyay.services;

import com.example.sawdhyay.daos.StudentDao;
import com.example.sawdhyay.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional
    public void addStudent(Student student) {
        this.studentDao.saveStudent(student);
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        this.studentDao.updateStudent(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        this.studentDao.deleteStudent(id);
    }

    @Override
    @Transactional
    public List<Student> findAllStudents() {
        return this.studentDao.listStudents();
    }

    @Override
    @Transactional
    public Student getStudentById(int id) {
        return this.studentDao.getStudent(id);
    }

    @Override
    @Transactional
    public Student getStudentByUserId(int id) {
        return  this.studentDao.getStudentByUserId(id);
    }
}

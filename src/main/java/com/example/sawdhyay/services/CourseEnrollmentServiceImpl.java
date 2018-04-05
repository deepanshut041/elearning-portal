package com.example.sawdhyay.services;

import com.example.sawdhyay.daos.CourseEnrollmentDao;
import com.example.sawdhyay.models.CourseEnrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("courseEnrollmentService")
public class CourseEnrollmentServiceImpl implements CourseEnrollmentService{

    @Autowired
    private CourseEnrollmentDao courseEnrollmentDao;

    @Override
    @Transactional
    public void addCourseEnrollment(CourseEnrollment courseEnrollment) {
        this.courseEnrollmentDao.saveCourseEnrollment(courseEnrollment);
    }

    @Override
    @Transactional
    public void updateCourseEnrollment(CourseEnrollment courseEnrollment) {
        this.courseEnrollmentDao.updateCourseEnrollment(courseEnrollment);
    }

    @Override
    @Transactional
    public void deleteCourseEnrollmentById(int id) {
        this.courseEnrollmentDao.deleteCourseEnrollment(id);
    }

    @Override
    @Transactional
    public List<CourseEnrollment> findAllCourseEnrollments() {
        return this.courseEnrollmentDao.listCourseEnrollments();
    }

    @Override
    @Transactional
    public CourseEnrollment getCourseEnrollmentById(int id) {
        return this.courseEnrollmentDao.getCourseEnrollment(id);
    }
}

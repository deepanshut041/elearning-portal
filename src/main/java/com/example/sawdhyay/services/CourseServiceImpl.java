package com.example.sawdhyay.services;

import com.example.sawdhyay.daos.CourseDao;
import com.example.sawdhyay.models.Course;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CourseServiceImpl implements CourseService{

    private CourseDao courseDao;

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    @Transactional
    public void addCourse(Course course) {
        this.courseDao.saveCourse(course);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        this.courseDao.updateCourse(course);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        this.courseDao.deleteCourse(id);
    }

    @Override
    @Transactional
    public List<Course> findAllCourses() {
        return this.courseDao.listCourses();
    }

    @Override
    @Transactional
    public Course getCourseById(int id) {
        return this.courseDao.getCourse(id);
    }
}

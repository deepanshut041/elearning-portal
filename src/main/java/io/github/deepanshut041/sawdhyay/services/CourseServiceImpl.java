package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.daos.CourseDao;
import io.github.deepanshut041.sawdhyay.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDao courseDao;

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

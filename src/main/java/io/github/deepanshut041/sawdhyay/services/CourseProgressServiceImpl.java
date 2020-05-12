package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.daos.CourseProgressDao;
import io.github.deepanshut041.sawdhyay.models.CourseProgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("courseProgressService")
public class CourseProgressServiceImpl implements CourseProgressService{

    @Autowired
    private CourseProgressDao courseProgressDao;

    @Override
    @Transactional
    public void addCourseProgress(CourseProgress courseProgress) {
        this.courseProgressDao.saveCourseProgress(courseProgress);
    }

    @Override
    @Transactional
    public void updateCourseProgress(CourseProgress courseProgress) {
        this.courseProgressDao.updateCourseProgress(courseProgress);
    }

    @Override
    @Transactional
    public void deleteCourseProgressById(int id) {
        this.courseProgressDao.deleteCourseProgress(id);
    }

    @Override
    @Transactional
    public List<CourseProgress> findAllCourseProgresss() {
        return this.courseProgressDao.listCourseProgresss();
    }

    @Override
    @Transactional
    public CourseProgress getCourseProgressById(int id) {
        return this.courseProgressDao.getCourseProgress(id);
    }

    @Override
    @Transactional
    public CourseProgress getCourseProgressByStepAndCourseProgress(int enroll_id, int step_id){
        return this.courseProgressDao.getCourseProgressByStepAndCourseProgress(enroll_id, step_id);
    }
}

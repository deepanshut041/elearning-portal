package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.models.CourseProgress;

import java.util.List;

public interface CourseProgressService {

    void addCourseProgress(CourseProgress courseProgress);

    void updateCourseProgress(CourseProgress courseProgress);

    void deleteCourseProgressById(int id);

    List<CourseProgress> findAllCourseProgresss();

    CourseProgress getCourseProgressById(int id);

    CourseProgress getCourseProgressByStepAndCourseProgress(int enroll_id, int step_id);
    
}

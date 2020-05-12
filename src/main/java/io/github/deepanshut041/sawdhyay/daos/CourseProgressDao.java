package io.github.deepanshut041.sawdhyay.daos;

import io.github.deepanshut041.sawdhyay.models.CourseProgress;

import java.util.List;

public interface CourseProgressDao {
    void saveCourseProgress(CourseProgress courseProgress);
    CourseProgress getCourseProgress(int id);
    List<CourseProgress> listCourseProgresss();
    void updateCourseProgress(CourseProgress courseProgress);
    void deleteCourseProgress(int id);
    CourseProgress getCourseProgressByStepAndCourseProgress(int enroll_id, int step_id);
}

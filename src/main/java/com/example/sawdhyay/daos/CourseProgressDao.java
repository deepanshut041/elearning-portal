package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.CourseProgress;

import java.util.List;

public interface CourseProgressDao {
    void saveCourseProgress(CourseProgress courseProgress);
    CourseProgress getCourseProgress(int id);
    List<CourseProgress> listCourseProgresss();
    void updateCourseProgress(CourseProgress courseProgress);
    void deleteCourseProgress(int id);
}

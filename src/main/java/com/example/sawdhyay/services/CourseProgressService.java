package com.example.sawdhyay.services;

import com.example.sawdhyay.models.CourseProgress;

import java.util.List;

public interface CourseProgressService {

    void addCourseProgress(CourseProgress courseProgress);

    void updateCourseProgress(CourseProgress courseProgress);

    void deleteCourseProgressById(int id);

    List<CourseProgress> findAllCourseProgresss();

    CourseProgress getCourseProgressById(int id);
    
}

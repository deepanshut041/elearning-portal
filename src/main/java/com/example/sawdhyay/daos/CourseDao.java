package com.example.sawdhyay.daos;

import com.example.sawdhyay.models.Course;

import java.util.List;

public interface CourseDao {

    void save(Course course);
    Course get(int id);
    List<Course> list();
    void update(int id, Course course);
    void delete(int id);

}

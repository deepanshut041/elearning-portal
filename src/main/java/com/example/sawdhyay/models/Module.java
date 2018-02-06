package com.example.sawdhyay.models;

public class Module {
    private String title;
    private Course course;
    private String description;

    public Module() {
    }

    public Module(String title, Course course, String description) {
        this.title = title;
        this.course = course;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

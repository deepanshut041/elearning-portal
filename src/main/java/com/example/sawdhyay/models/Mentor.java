package com.example.sawdhyay.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    private String name;
    private String about;

    @ManyToMany(mappedBy = "mentors")
    private List<Course> courses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

}

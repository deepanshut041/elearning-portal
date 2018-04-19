package com.example.sawdhyay.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "*Please provide an title")
    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "language")
    private List<Course> courses;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "language")
    private List<Fquestion> fquestions;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Fquestion> getFquestions() {
        return fquestions;
    }

    public void setFquestions(List<Fquestion> fquestions) {
        this.fquestions = fquestions;
    }
}

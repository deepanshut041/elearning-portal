package com.example.sawdhyay.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "*Please provide an title")
    private String title;

    @NotEmpty(message = "*Please provide an Description")
    private String Description;
    private int length;

    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(name="track_course", joinColumns = @JoinColumn(name="track_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses;


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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}

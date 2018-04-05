package com.example.sawdhyay.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course_enrollment")
public class CourseEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date enroll_date;

    @ManyToOne
    private User user;

    @ManyToOne
    private Course course;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course_enrollment", fetch = FetchType.EAGER)
    private Set<CourseProgress> progresses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getEnroll_date() {
        return enroll_date;
    }

    public void setEnroll_date(Date enroll_date) {
        this.enroll_date = enroll_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Set<CourseProgress> getProgresses() {
        return progresses;
    }

    public void setProgresses(Set<CourseProgress> progresses) {
        this.progresses = progresses;
    }
}

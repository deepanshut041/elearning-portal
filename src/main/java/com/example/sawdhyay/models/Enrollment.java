package com.example.sawdhyay.models;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @CreationTimestamp
    private Date enroll_date;

    @ManyToOne(fetch = FetchType.EAGER)
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    private Course course;

    @OneToMany(cascade =  CascadeType.MERGE, mappedBy = "enrollment", fetch = FetchType.EAGER)
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

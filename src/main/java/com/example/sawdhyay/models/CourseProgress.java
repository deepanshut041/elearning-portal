package com.example.sawdhyay.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CourseProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private CourseEnrollment enrollment;

    @ManyToOne
    private Step step;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date completed_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CourseEnrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(CourseEnrollment enrollment) {
        this.enrollment = enrollment;
    }

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }

    public Date getCompleted_date() {
        return completed_date;
    }

    public void setCompleted_date(Date completed_date) {
        this.completed_date = completed_date;
    }
}

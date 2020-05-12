package io.github.deepanshut041.sawdhyay.models;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "course_progress")
public class CourseProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Enrollment enrollment;

    @ManyToOne
    private Step step;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @CreationTimestamp
    private Date completed_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
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

package com.example.sawdhyay.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "*Please provide an title")
    private String title;

    @NotEmpty(message = "*Please provide a description")
    @Column(columnDefinition="TEXT")
    private String description;

    @NotEmpty(message = "*Please provide status")
    private String status;

    private boolean paid;

    @NotEmpty(message = "*Please provide an language")
    private String language;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date start_date;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date enroll_date;

    @NotEmpty(message = "*Please provide skill Required")
    private String skill_required;

    @NotEmpty(message = "*Please provide Trailer Link")
    private String trailer_link;

    private int course_length;

    public Set<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Set<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    @ManyToOne
    @JoinColumn(name ="category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name ="tech_language_id")
    private Language tech_language;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course", fetch = FetchType.EAGER)
    private Set<Module> modules;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="course", fetch = FetchType.LAZY)
    private Set<Enrollment> enrollments;

    @ManyToOne(fetch = FetchType.EAGER)
    private Mentor mentor;

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Track> tracks;


    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

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
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnroll_date() {
        return enroll_date;
    }

    public Language getTech_language() {
        return tech_language;
    }

    public void setTech_language(Language tech_language) {
        this.tech_language = tech_language;
    }

    public void setEnroll_date(Date enroll_date) {
        this.enroll_date = enroll_date;
    }

    public String getSkill_required() {
        return skill_required;
    }

    public void setSkill_required(String skill_required) {
        this.skill_required = skill_required;
    }

    public String getTrailer_link() {
        return trailer_link;
    }

    public void setTrailer_link(String trailer_link) {
        this.trailer_link = trailer_link;
    }

    public int getCourse_length() {
        return course_length;
    }

    public void setCourse_length(int course_length) {
        this.course_length = course_length;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }
}

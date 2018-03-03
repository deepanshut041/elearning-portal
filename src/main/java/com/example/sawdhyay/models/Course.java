package com.example.sawdhyay.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(columnDefinition="TEXT")
    private String description;
    private String status;
    private boolean paid;
    private String language;
    private Date start_date;
    private Date enroll_date;
    private String skill_required;
    private String trailer_link;
    private int course_length;

    @ManyToMany
    @JoinTable(name="mentor_course", joinColumns = @JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name = "mentor_id"))
    private List<Mentor> mentors;

    @ManyToOne
    @JoinColumn(name ="category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name ="tech_language_id")
    private Language tech_language;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course", fetch = FetchType.EAGER)
    private List<Module> modules;

    public List<Mentor> getMentors() {
        return mentors;
    }

    public void setMentors(List<Mentor> mentors) {
        this.mentors = mentors;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
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
}

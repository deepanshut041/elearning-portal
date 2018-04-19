package com.example.sawdhyay.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

public class Fquestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String question;

    @Column(columnDefinition="TEXT")
    private String description;

    @CreationTimestamp
    private Date created_at;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    private Language language;

    @ManyToOne(fetch = FetchType.EAGER)
    private Student student;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fquestion", fetch = FetchType.EAGER)
    private Set<Fanswer> fanswers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Set<Fanswer> getFanswers() {
        return fanswers;
    }

    public void setFanswers(Set<Fanswer> fanswers) {
        this.fanswers = fanswers;
    }
}

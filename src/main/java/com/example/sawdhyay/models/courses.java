package com.example.sawdhyay.models;

import java.text.DateFormat;

public class courses {
    private String title;
    private String description;
    private String status;
    private boolean paid;

    public courses(String title, String description, String status, boolean paid, String language, DateFormat start_date, DateFormat enroll_date, String skill_required, String author_id, String trailer_link, int course_length, String category, String programming_language) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.paid = paid;
        this.language = language;
        this.start_date = start_date;
        this.enroll_date = enroll_date;
        this.skill_required = skill_required;
        this.author_id = author_id;
        this.trailer_link = trailer_link;
        this.course_length = course_length;
        this.category = category;
        this.programming_language = programming_language;
    }

    private String language;
    private DateFormat start_date;
    private DateFormat enroll_date;
    private String skill_required;
    private String author_id;
    private String trailer_link;
    private int course_length;
    private String category;
    private String  programming_language;

    public courses() {
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

    public DateFormat getStart_date() {
        return start_date;
    }

    public void setStart_date(DateFormat start_date) {
        this.start_date = start_date;
    }

    public DateFormat getEnroll_date() {
        return enroll_date;
    }

    public void setEnroll_date(DateFormat enroll_date) {
        this.enroll_date = enroll_date;
    }

    public String getSkill_required() {
        return skill_required;
    }

    public void setSkill_required(String skill_required) {
        this.skill_required = skill_required;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProgramming_language() {
        return programming_language;
    }

    public void setProgramming_language(String programming_language) {
        this.programming_language = programming_language;
    }
}

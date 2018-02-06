package com.example.sawdhyay.models;

public class Mentors {
    private int id;
    private String name;
    private String about;
    private String gitlink;
    private String linkedlink;

    public Mentors() {
    }

    public Mentors(int id, String name, String about, String gitlink, String linkedlink) {
        this.id = id;
        this.name = name;
        this.about = about;
        this.gitlink = gitlink;
        this.linkedlink = linkedlink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getGitlink() {
        return gitlink;
    }

    public void setGitlink(String gitlink) {
        this.gitlink = gitlink;
    }

    public String getLinkedlink() {
        return linkedlink;
    }

    public void setLinkedlink(String linkedlink) {
        this.linkedlink = linkedlink;
    }
}

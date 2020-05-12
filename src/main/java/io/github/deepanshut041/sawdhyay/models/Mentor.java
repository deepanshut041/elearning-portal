package io.github.deepanshut041.sawdhyay.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    @Column(columnDefinition="TEXT")
    private String about;

    @OneToOne
    private User user;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mentor")
    private Set<Course> courses;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mentor")
    private Set<Post> posts;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}

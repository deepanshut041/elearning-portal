package com.example.sawdhyay.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Pcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;

    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "pcategory")
    private Set<Post> posts;

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

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}

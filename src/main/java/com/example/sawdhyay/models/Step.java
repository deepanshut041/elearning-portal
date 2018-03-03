package com.example.sawdhyay.models;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

@Entity
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    private String type;
    @Column(columnDefinition="TEXT")
    private String detail;
    private String link;

    @ManyToOne(fetch = FetchType.LAZY)
    private Module module;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}

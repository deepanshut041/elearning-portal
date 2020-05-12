package io.github.deepanshut041.sawdhyay.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;

    private String type;
    @Column(columnDefinition="TEXT")
    private String detail;

    @Column(columnDefinition = "TEXT")
    private String content;
    private String link;

    @ManyToOne(fetch = FetchType.LAZY)
    private Module module;

    private int length;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "step", fetch = FetchType.LAZY)
    private Set<CourseProgress> courseProgress;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "step", fetch = FetchType.LAZY)
    private Set<CourseProgress> progresses;

    public Set<CourseProgress> getProgresses() {
        return progresses;
    }

    public void setProgresses(Set<CourseProgress> progresses) {
        this.progresses = progresses;
    }
    public Set<CourseProgress> getCourseProgress() {
        return courseProgress;
    }

    public void setCourseProgress(Set<CourseProgress> courseProgress) {
        this.courseProgress = courseProgress;
    }


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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

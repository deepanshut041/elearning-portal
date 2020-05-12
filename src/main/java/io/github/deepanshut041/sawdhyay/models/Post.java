package io.github.deepanshut041.sawdhyay.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "*Please provide an title")
    private String title;

    @NotEmpty(message = "*Please provide a content")
    @Column(columnDefinition="TEXT")
    private String content;

    @NotEmpty(message = "*Please provide short content")
    @Column(columnDefinition="TEXT")
    private String short_content;


    @CreationTimestamp
    private Date date_created;

    @UpdateTimestamp
    private Date date_updated;

    @NotEmpty(message = "*Please provide short image link")
    private String img_link;

    @ManyToOne
    private Mentor mentor;

    @ManyToOne
    private Pcategory pcategory;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private Set<Comment> comments;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate_created() {
        return date_created;
    }

    public String getImg_link() {
        return img_link;
    }

    public void setImg_link(String img_link) {
        this.img_link = img_link;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(Date date_updated) {
        this.date_updated = date_updated;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public Pcategory getPcategory() {
        return pcategory;
    }

    public void setPcategory(Pcategory pcategory) {
        this.pcategory = pcategory;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public String getShort_content() {
        return short_content;
    }

    public void setShort_content(String short_content) {
        this.short_content = short_content;
    }

}

package karol.appdemo.spotted;


import karol.appdemo.user.Role;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "spotted_post")
public class SpottedPost {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "spotted_post_id")
    private int id;

    @Column(name = "spotted_author")
    @NotNull
    private String author;

    @Column(name = "spotted_title")
    @NotNull
    private String title;

    @Column(name = "spoted_content")
    @NotNull
    private String content;

    @Column(name = "spotted_createon")
    @NotNull
    private String createOn;

    @Lob
    @Column(name = "spotted_data")
    private byte[] data;

    @Column(name = "spotted_like")
    @NotNull
    private int spottedLike;

    @Column(name = "spotted_dislike")
    @NotNull
    private int spottedDislike;

    @Transient
    private String image;


    // getter and setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getCreateOn() {
        return createOn;
    }

    public void setCreateOn(String createOn) {
        this.createOn = createOn;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getSpottedLike() {
        return spottedLike;
    }

    public void setSpottedLike(int spottedLike) {
        this.spottedLike = spottedLike;
    }

    public int getSpottedDislike() {
        return spottedDislike;
    }

    public void setSpottedDislike(int spottedDislike) {
        this.spottedDislike = spottedDislike;
    }
}

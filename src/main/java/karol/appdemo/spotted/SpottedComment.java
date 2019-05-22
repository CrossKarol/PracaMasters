package karol.appdemo.spotted;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "spotted_comment")
public class SpottedComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "spotted_comment_id")
    private int id;
    @Column(name = "spotted_comment_author")
    @NotNull
    private String author;
    @Column(name = "spotted_comment_title")
    @NotNull
    private String title;
    @Column(name = "spotted_comment_content")
    @NotNull
    private String content;
    @Column(name = "spotted_comment_createon")
    @NotNull
    private String createOn;

    @Lob
    @Column(name = "spotted_comment_data")
    private byte[] data;
    @Transient
    private String image;

    @Column(name = "id_join_post")
    @NotNull
    private int id_post;

    @Column(name = "spotted_comment_like")
    @NotNull
    private int spottedLikeComment;

    @Column(name = "spotted_comment_dislike")
    @NotNull
    private int spottedDislikeComment;



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

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public int getSpottedLikeComment() {
        return spottedLikeComment;
    }

    public void setSpottedLikeComment(int spottedLikeComment) {
        this.spottedLikeComment = spottedLikeComment;
    }

    public int getSpottedDislikeComment() {
        return spottedDislikeComment;
    }

    public void setSpottedDislikeComment(int spottedDislikeComment) {
        this.spottedDislikeComment = spottedDislikeComment;
    }
}

package karol.appdemo.post;

import javax.persistence.*;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private int id;

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name = "content")
    @NotNull
    private String content;

    @Column(name = "create_on")
    @NotNull
    private String createdOn;

    @Column(name = "author")
    @NotNull
    private String author;

    @Lob
    @Column(name = "data_post")
    private byte[] data;


    @Transient
    private String image;


    @Transient
    private int nrPost;

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


    public int getNrPost() {
        return nrPost;
    }

    public void setNrPost(int nrPost) {
        this.nrPost = nrPost;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}

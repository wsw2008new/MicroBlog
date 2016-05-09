package models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by alikemal on 02.05.2016.
 */
@Entity
@Table(name = "Post", schema = "", catalog = "ali_asp")
public class PostEntity {
    private int postId;
    private String postTitle;
    private Timestamp postCreateDate;
    private Integer postPoint;
    private Byte postEditable;
    private String postContent;
    private Integer postEmoji;
    private int postAuther;

    @Id
    @Column(name = "Post_Id", nullable = false)
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "Post_Title", nullable = false, length = 100)
    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    @Basic
    @Column(name = "Post_CreateDate", nullable = false)
    public Timestamp getPostCreateDate() {
        return postCreateDate;
    }

    public void setPostCreateDate(Timestamp postCreateDate) {
        this.postCreateDate = postCreateDate;
    }

    @Basic
    @Column(name = "Post_Point", nullable = true)
    public Integer getPostPoint() {
        return postPoint;
    }

    public void setPostPoint(Integer postPoint) {
        this.postPoint = postPoint;
    }

    @Basic
    @Column(name = "Post_Content", nullable = true, length = 200)
    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    @Basic
    @Column(name = "Post_Emoji", nullable = true)
    public Integer getPostEmoji() {
        return postEmoji;
    }

    public void setPostEmoji(Integer postEmoji) {
        this.postEmoji = postEmoji;
    }

    @Basic
    @Column(name = "Post_Auther", nullable = false)
    public int getPostAuther() {
        return postAuther;
    }

    public void setPostAuther(int postAuther) {
        this.postAuther = postAuther;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostEntity that = (PostEntity) o;

        if (postId != that.postId) return false;
        if (postAuther != that.postAuther) return false;
        if (postTitle != null ? !postTitle.equals(that.postTitle) : that.postTitle != null) return false;
        if (postCreateDate != null ? !postCreateDate.equals(that.postCreateDate) : that.postCreateDate != null)
            return false;
        if (postPoint != null ? !postPoint.equals(that.postPoint) : that.postPoint != null) return false;
        if (postEditable != null ? !postEditable.equals(that.postEditable) : that.postEditable != null) return false;
        if (postContent != null ? !postContent.equals(that.postContent) : that.postContent != null) return false;
        if (postEmoji != null ? !postEmoji.equals(that.postEmoji) : that.postEmoji != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = postId;
        result = 31 * result + (postTitle != null ? postTitle.hashCode() : 0);
        result = 31 * result + (postCreateDate != null ? postCreateDate.hashCode() : 0);
        result = 31 * result + (postPoint != null ? postPoint.hashCode() : 0);
        result = 31 * result + (postEditable != null ? postEditable.hashCode() : 0);
        result = 31 * result + (postContent != null ? postContent.hashCode() : 0);
        result = 31 * result + (postEmoji != null ? postEmoji.hashCode() : 0);
        result = 31 * result + postAuther;
        return result;
    }
}

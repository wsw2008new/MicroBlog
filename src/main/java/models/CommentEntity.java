package models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by alikemal on 02.05.2016.
 */
@Entity
@Table(name = "Comment", schema = "", catalog = "ali_asp")
public class CommentEntity {
    private int commentId;
    private String commentContent;
    private int commentAuthor;
    private Integer commentEmoji;
    private Timestamp commentCreateDate;
    private Integer commentPoint;
    private Byte commentEditable;
    private Integer commentPostid;

    @Id
    @Column(name = "Comment_ID", nullable = false)
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "Comment_Content", nullable = false, length = 200)
    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Basic
    @Column(name = "Comment_Author", nullable = false)
    public int getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(int commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    @Basic
    @Column(name = "Comment_Emoji", nullable = true)
    public Integer getCommentEmoji() {
        return commentEmoji;
    }

    public void setCommentEmoji(Integer commentEmoji) {
        this.commentEmoji = commentEmoji;
    }

    @Basic
    @Column(name = "Comment_CreateDate", nullable = false)
    public Timestamp getCommentCreateDate() {
        return commentCreateDate;
    }

    public void setCommentCreateDate(Timestamp commentCreateDate) {
        this.commentCreateDate = commentCreateDate;
    }

    @Basic
    @Column(name = "Comment_Point", nullable = true)
    public Integer getCommentPoint() {
        return commentPoint;
    }

    public void setCommentPoint(Integer commentPoint) {
        this.commentPoint = commentPoint;
    }

    @Basic
    @Column(name = "Comment_Editable", nullable = true)
    public Byte getCommentEditable() {
        return commentEditable;
    }

    public void setCommentEditable(Byte commentEditable) {
        this.commentEditable = commentEditable;
    }

    @Basic
    @Column(name = "Comment_POSTID", nullable = true)
    public Integer getCommentPostid() {
        return commentPostid;
    }

    public void setCommentPostid(Integer commentPostid) {
        this.commentPostid = commentPostid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (commentId != that.commentId) return false;
        if (commentAuthor != that.commentAuthor) return false;
        if (commentContent != null ? !commentContent.equals(that.commentContent) : that.commentContent != null)
            return false;
        if (commentEmoji != null ? !commentEmoji.equals(that.commentEmoji) : that.commentEmoji != null) return false;
        if (commentCreateDate != null ? !commentCreateDate.equals(that.commentCreateDate) : that.commentCreateDate != null)
            return false;
        if (commentPoint != null ? !commentPoint.equals(that.commentPoint) : that.commentPoint != null) return false;
        if (commentEditable != null ? !commentEditable.equals(that.commentEditable) : that.commentEditable != null)
            return false;
        if (commentPostid != null ? !commentPostid.equals(that.commentPostid) : that.commentPostid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentId;
        result = 31 * result + (commentContent != null ? commentContent.hashCode() : 0);
        result = 31 * result + commentAuthor;
        result = 31 * result + (commentEmoji != null ? commentEmoji.hashCode() : 0);
        result = 31 * result + (commentCreateDate != null ? commentCreateDate.hashCode() : 0);
        result = 31 * result + (commentPoint != null ? commentPoint.hashCode() : 0);
        result = 31 * result + (commentEditable != null ? commentEditable.hashCode() : 0);
        result = 31 * result + (commentPostid != null ? commentPostid.hashCode() : 0);
        return result;
    }
}

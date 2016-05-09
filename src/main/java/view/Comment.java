package view;

import models.CommentEntity;
import presentation.IMPL.CommentDB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import java.util.List;

/**
 * Created by alikemal on 14.04.2016.
 */
@ManagedBean(name = "comment")
@SessionScoped

public class Comment extends BaseView {
    final private CommentDB commentDB = new CommentDB();
    private CommentEntity comment = new CommentEntity();
    private int postID;

    public CommentEntity getComment() {
        return comment;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public void setPostID(ActionEvent event) {
        setPostID((Integer) event.getComponent().getAttributes().get("postid"));
    }

    public List<CommentEntity> listByPost() {
        return commentDB.listByPost(getPostID());
    }

    public String insert(int authotID) {
        getComment().setCommentPostid(getPostID());
        getComment().setCommentAuthor(authotID);
        commentDB.insert(getComment());
        return "postDetails";
    }

    public String delete(ActionEvent event) {
        commentDB.delete((Integer) event.getComponent().getAttributes().get("commentid"));
        return "postDetails";
    }

    public String update() {
        commentDB.update(getComment());
        return "postDetails";
    }

}

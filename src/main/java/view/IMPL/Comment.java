package view.IMPL;

import models.CommentEntity;
import presentation.CommentDao;
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

public class Comment extends BaseBusiness {
    final private CommentDao commentDB = new CommentDB();
    private CommentEntity comment = null;
    private int postID;

    public CommentEntity getComment() {
        return comment;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(ActionEvent event) {
        setPostID((Integer) event.getComponent().getAttributes().get("postid"));
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public List<CommentEntity> listByPost() {
        return commentDB.listByPost(getPostID());
    }

    public String insert() {
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

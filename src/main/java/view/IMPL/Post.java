package view.IMPL;

import models.PostEntity;
import models.UserDataEntity;
import presentation.IMPL.PostDB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by alikemal on 08.04.2016.
 */
@ManagedBean(name = "post")
@RequestScoped


public class Post extends BaseBusiness {
    final private PostDB postDB = new PostDB();


    UserDataEntity user = new UserDataEntity();
    PostEntity post = new PostEntity();


    public UserDataEntity getUser() {
        return user;
    }

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    public List<PostEntity> listUserPost() {
        return postDB.listAuther(user.getUserId());
    }


    public ResultSet list() {
        return null;
    }


    public String insert() {
        post.setPostAuther(findIdbyUserEmail(getUser().getUserEmail()));
        postDB.insert(post);
        return "index";
    }


    public String delete() {
        return null;
    }


    public String update() {
        return null;
    }

    public void listenerlistAutherPost(ActionEvent event) {
        user.setUserId(findIdbyUserEmail((String) event.getComponent().getAttributes().get("user_email")));

    }
}

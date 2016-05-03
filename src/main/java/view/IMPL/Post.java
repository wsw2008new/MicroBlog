package view.IMPL;

import models.PostEntity;
import presentation.IMPL.PostDB;
import presentation.PostDao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.util.List;

/**
 * Created by alikemal on 08.04.2016.
 */
@ManagedBean(name = "post")
@SessionScoped


public class Post extends BaseBusiness {
    final private PostDao postDB = new PostDB();
    private PostEntity post = new PostEntity();
    private User user = null;

    private int userid;

    public Post() {
        user = (User) FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get("user");
    }

    public int getUserid() {
        return user.getCurrentuser().getUserId();
    }

    public void listenerSetUserid(ActionEvent event) {
        userid = (Integer) event.getComponent().getAttributes().get("userid");
    }

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    public List<PostEntity> listAllPost() {
        return postDB.listAll();
    }


    public String insert() {
        post.setPostAuther(userid);
        postDB.insert(post);
        return "index";
    }


    public String delete(ActionEvent event) {
        postDB.delete((Integer) event.getComponent().getAttributes().get("postid"));
        return "postDetails";
    }

    public String update() {
        postDB.update(post);
        return "postDetails";
    }

    public List<PostEntity> listAutherPost() {
        return postDB.listAuther(getUserid());
    }
}

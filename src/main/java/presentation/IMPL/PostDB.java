package presentation.IMPL;

import models.PostEntity;
import presentation.PostDao;

import java.util.List;


/**
 * Created by alikemal on 24.04.2016.
 */

public class PostDB extends Base implements PostDao {
    public PostDB() {
        super.getManager();
        super.getEtx();
    }

    @Override
    public List<PostEntity> listAuther(int id) {
        return getManager()
                .createQuery("Select a from PostEntity a where a.postAuther= ?1 ", PostEntity.class)
                .setParameter(1, id).getResultList();
    }

    @Override
    public List<PostEntity> listAll() {
        return getManager()
                .createQuery("Select a from PostEntity a ", PostEntity.class)
                .getResultList();
    }

    @Override
    public void insert(PostEntity post) {
        persist(post);
    }


    @Override
    public void delete(int id) {
        getEtx().begin();
        getManager().remove(findPost(id));
        getEtx().commit();
    }

    @Override
    public void update(PostEntity post) {
        getEtx().begin();
        getManager().createQuery(
                "UPDATE PostEntity SET postTitle = ?1,postContent= ?2, postCreateDate= ?3 ,postEditable= ?4,postEmoji=?5,postPoint=?6,postAuther=?8" +
                        "WHERE postId = ?7")
                .setParameter(1, post.getPostTitle())
                .setParameter(2, post.getPostContent())
                .setParameter(3, post.getPostCreateDate())
                .setParameter(4, post.getPostEditable())
                .setParameter(5, post.getPostEmoji())
                .setParameter(6, post.getPostPoint())
                .setParameter(8, post.getPostAuther())
                .setParameter(7, post.getPostId()).executeUpdate();
        getEtx().commit();
    }

}

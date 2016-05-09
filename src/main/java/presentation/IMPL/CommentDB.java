package presentation.IMPL;

import models.CommentEntity;
import presentation.CommentDao;

import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by alikemal on 29.04.2016.
 */

public class CommentDB extends Base implements CommentDao {
    public CommentDB() {
        super.getManager();
        super.getEtx();
    }

    @Override
    public List<CommentEntity> listByPost(int id) {
        return getManager()
                .createQuery("Select a from CommentEntity a where a.commentPostid= ?1 ", CommentEntity.class)
                .setParameter(1, id)
                .getResultList();
    }

    @Override
    public List<CommentEntity> listAllByUser(int id) {
        return getManager()
                .createQuery("Select a from CommentEntity a where a.commentAuthor= ?1 ", CommentEntity.class)
                .setParameter(1, id)
                .getResultList();
    }

    @Override
    public void insert(CommentEntity comment) {
        comment.setCommentCreateDate(new Timestamp(new Date().getTime()));
        persist(comment);
    }


    @Override
    public void delete(int id) {
        getEtx().begin();
        getManager().remove(findComment(id));
        getEtx().commit();
    }

    @Override
    public void update(CommentEntity comment) {
        getEtx().begin();
        Query query = getManager().createQuery(
                "UPDATE CommentEntity SET commentContent = ?1,commentCreateDate= ?2, commentEditable= ?3 ,commentPoint= ?4,commentEmoji=?5,commentAuthor=?7,commentPostid=?8" +
                        "WHERE  commentId= ?6");
        query.setParameter(1, comment.getCommentContent())
                .setParameter(2, comment.getCommentCreateDate())
                .setParameter(3, comment.getCommentEditable())
                .setParameter(4, comment.getCommentPoint())
                .setParameter(5, comment.getCommentEmoji())
                .setParameter(6, comment.getCommentId())
                .setParameter(7, comment.getCommentAuthor())
                .setParameter(8, comment.getCommentPostid()).executeUpdate();
        getEtx().commit();
    }


}

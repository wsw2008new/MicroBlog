package presentation;

import models.CommentEntity;

import java.util.List;

/**
 * Created by alikemal on 19.04.2016.
 */
public interface CommentDao {
    List<CommentEntity> listPostComment(int id);

    List<CommentEntity> listAllByUser(int id);

    void insert(CommentEntity comment);

    void delete(int id);

    void update(CommentEntity comment);
}

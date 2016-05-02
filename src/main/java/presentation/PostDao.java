package presentation;


import models.PostEntity;

import java.util.List;

/**
 * Created by alikemal on 19.04.2016.
 */
public interface PostDao {

    List<PostEntity> listAuther(int id);

    void insert(PostEntity post);

    void delete(int id);

    void update(PostEntity post);
}

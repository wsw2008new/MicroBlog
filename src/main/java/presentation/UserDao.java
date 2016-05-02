package presentation;

import models.UserDataEntity;

import java.util.List;

/**
 * Created by alikemal on 19.04.2016.
 */
public interface UserDao {

    List<UserDataEntity> list();

    void insert(UserDataEntity user);

    void delete(int id);

    void update(UserDataEntity user);
}

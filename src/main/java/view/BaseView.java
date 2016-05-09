package view;

import models.UserDataEntity;
import presentation.IMPL.UserDB;

/**
 * Created by alikemal on 08.04.2016.
 */

public abstract class BaseView {

    public String findUserByID(int id) {
        UserDataEntity user = new UserDB().findUser(id);
        return user.getUserFirstName() + " " + user.getUserLastName();
    }
}

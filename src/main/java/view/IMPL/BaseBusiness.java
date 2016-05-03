package view.IMPL;

import models.UserDataEntity;
import presentation.IMPL.UserDB;

import java.util.List;

/**
 * Created by alikemal on 08.04.2016.
 */

public class BaseBusiness {

    public int findIdbyUserEmail(String nickname) {
        List<UserDataEntity> rs = new UserDB().list();

        for (UserDataEntity user : rs) {
            if (user.getUserNickName().equals(nickname)) {
                return user.getUserId();
            }
        }
        return 0;
    }

    public String findUserbyID(int id) {
        List<UserDataEntity> rs = new UserDB().list();

        for (UserDataEntity user : rs) {
            if (user.getUserId() == id) {
                return user.getUserNickName();
            }
        }
        return null;
    }
}

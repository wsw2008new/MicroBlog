package view.IMPL;

import models.UserDataEntity;
import presentation.IMPL.UserDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by alikemal on 08.04.2016.
 */

public class BaseBusiness {

    public int findIdbyUserEmail(String nickname) {

        List<UserDataEntity> rs = new UserDB().list();
        Iterator<UserDataEntity> itr = rs.iterator();

        while (itr.hasNext()) {
            if (itr.next().getUserNickName().equals(nickname)) {

                return itr.next().getUserId();
            }
        }
        return 0;
    }

    public String findUserbyID(int id) {

        List<UserDataEntity> rs = new UserDB().list();
        Iterator<UserDataEntity> itr = rs.iterator();

        while (itr.hasNext()) {
            if (itr.next().getUserId() == id) {

                return itr.next().getUserNickName();
            }
        }
        return null;
    }

    public void setUser(UserDataEntity user, ResultSet rs) {
        try {
            user.setUserId(rs.getInt("User_Id"));
            user.setUserFirstName(rs.getString("User_FirstName"));
            user.setUserLastName(rs.getString("User_LastName"));
            user.setUserNickName(rs.getString("User_NickName"));
            user.setUserSifre(rs.getString("User_Sifre"));
            user.setUserPoint(rs.getInt("User_Point"));
            user.setUsePermission(rs.getByte("Use_Permission"));
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("row hatası");
        }
    }

}

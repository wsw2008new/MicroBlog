package view.IMPL;

import models.UserDataEntity;
import presentation.IMPL.UserDB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.convert.Converter;
import java.util.Iterator;
import java.util.List;

/**
 * Created by alikemal on 04.04.2016.
 */
@ManagedBean(name = "user")
@SessionScoped

public class User extends BaseBusiness {
    public static models.UserDataEntity currentuser = new models.UserDataEntity();
    final private UserDB userdb = new UserDB();
    private String errorMesg;

    public String getErrorMesg() {
        return errorMesg;
    }

    public void setErrorMesg(String errorMesg) {
        this.errorMesg = errorMesg;
    }

    public UserDataEntity getCurrentuser() {
        return currentuser;
    }

    public static void setCurrentuser(UserDataEntity currentuser) {
        User.currentuser = currentuser;
    }

    public List<UserDataEntity> list() {
        return userdb.list();
    }


    public String insert() {
        return null;
    }


    public String delete() {
        return null;
    }


    public String update() {
        return null;
    }


    public Boolean isAdmin(Byte rt) {
        return rt.equals(true);
    }

    public Boolean isUser(UserDataEntity user) {
        List<UserDataEntity> rs = userdb.list();
        Iterator<UserDataEntity> itr = rs.iterator();

        rs.stream().filter(userDataEntity -> userDataEntity.getUserEmail().equals(user.getUserEmail()))
                .filter(userDataEntity -> userDataEntity.getUserSifre().equals(user.getUserSifre()))
                .forEach(User::setCurrentuser);
        try {
            while (itr.hasNext()) {
                UserDataEntity us = itr.next();
                if (us.getUserEmail().equals(user.getUserEmail())) {
                    if (itr.next().equals(user.getUserSifre())) {
                        setCurrentuser(us);
                        System.out.println(getCurrentuser().getUserNickName());
                        setErrorMesg("giriş başarili");
                        return true;
                    } else {
                        setErrorMesg("sifre hatali");
                        return false;
                    }

                } else {
                    setErrorMesg("kullanıcı adi hatali");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setErrorMesg("kullanici kontrol başarisiz");
        return false;
    }

    public String doLogin() {
        if (isUser(getCurrentuser())) {
            if (isAdmin((getCurrentuser().getUsePermission()))) {
                return "index";
            } else return "index";
        } else return "login";
    }


}

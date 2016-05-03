package view.IMPL;

import models.UserDataEntity;
import presentation.IMPL.UserDB;
import presentation.UserDao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import java.util.Iterator;
import java.util.List;

/**
 * Created by alikemal on 04.04.2016.
 */
@ManagedBean(name = "user")
@SessionScoped

public class User extends BaseBusiness {
    final private UserDao userdb = new UserDB();
    private UserDataEntity currentuser = null;
    private UserDataEntity usertemp = null;
    private String errorMesg;

    public UserDataEntity getUsertemp() {
        return usertemp;
    }

    public String getErrorMesg() {
        return errorMesg;
    }

    public void setErrorMesg(String errorMesg) {
        this.errorMesg = errorMesg;
    }

    public UserDataEntity getCurrentuser() {
        return currentuser;
    }

    public void setCurrentuser(UserDataEntity currentuser) {
        this.currentuser = currentuser;
    }

    public List<UserDataEntity> list() {
        return userdb.list();
    }


    public String insert() {
        userdb.insert(getUsertemp());
        return "userDetails";
    }


    public String delete(ActionEvent event) {
        userdb.delete((Integer) event.getComponent().getAttributes().get("postid"));
        return "index";
    }


    public String update() {
        userdb.update(getUsertemp());
        return "userDetails";
    }


    public Boolean isAdmin(Byte rt) {
        return rt.equals(true);
    }

    public Boolean isUser(UserDataEntity user) {
        List<UserDataEntity> rs = userdb.list();
        Iterator<UserDataEntity> itr = rs.iterator();

        rs.stream()
                .filter(userDataEntity -> userDataEntity.getUserEmail().equals(user.getUserEmail()))
                .filter(userDataEntity -> userDataEntity.getUserSifre().equals(user.getUserSifre()))
                .forEach(userDataEntity -> setCurrentuser(userDataEntity));
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

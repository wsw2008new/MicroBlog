package view.IMPL;

import models.UserDataEntity;
import presentation.IMPL.UserDB;
import presentation.UserDao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import java.util.List;

/**
 * Created by alikemal on 04.04.2016.
 */
@ManagedBean(name = "user")
@SessionScoped

public class User extends BaseBusiness {
    final private UserDao userdb = new UserDB();
    private UserDataEntity currentuser = new UserDataEntity();
    private UserDataEntity usertemp = new UserDataEntity();
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
        userdb.delete((Integer) event.getComponent().getAttributes().get("userid"));
        return "index";
    }


    public String update() {
        userdb.update(getUsertemp());
        return "userDetails";
    }


    public Boolean isAdmin(Boolean rt) {
        return rt.equals(true);
    }

    public Boolean isUser(UserDataEntity user) {
        List<UserDataEntity> users = userdb.list();

        for (UserDataEntity us : users) {
            if (us.getUserEmail().equals(user.getUserEmail())) {
                if (us.getUserSifre().equals(user.getUserSifre())) {
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

    public Boolean IsLogin(){
        if(currentuser.getUserId()!=0){
            return true;
        }
        return false;
    }
    public String doLogout(){
        getCurrentuser().setUserId(0);
        return "index";
    }

}

package view.IMPL;

import models.UserDataEntity;
import org.junit.Test;

/**
 * Created by alikemal on 03.05.2016.
 */
public class UserTest {
    User user=new User();


    @Test
    public void isUser() throws Exception {
        UserDataEntity person=new UserDataEntity();
        person.setUserEmail("alikemal@gmail.com");
        person.setUserSifre("23456");
        System.out.println(user.isUser(person));
    }

    @Test
    public void doLogin() throws Exception {

        UserDataEntity person=new UserDataEntity();
        person.setUserEmail("alikemal@gmail.com");
        person.setUserSifre("23456");
        user.setCurrentuser(person);
        System.out.println( user.doLogin());
    }

}
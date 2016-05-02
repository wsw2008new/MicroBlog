package presentation.IMPL;

import models.UserDataEntity;
import org.junit.Test;

/**
 * Created by alikemal on 30.04.2016.
 */
public class UserDBTest {
    UserDB userDB=new UserDB();
    @Test
    public void insert() throws Exception {
        UserDataEntity user = new UserDataEntity();
        user.setUserEmail("murat@goyimdeturat.com");
        user.setUserFirstName("murat");
        userDB.insert(user);
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

}
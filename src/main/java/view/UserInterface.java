package view;

/**
 * Created by alikemal on 07.04.2016.
 */
public interface UserInterface {

    Boolean isAdmin(Boolean rt);

    Boolean isUser(models.UserDataEntity user);

    String doLogin();

}

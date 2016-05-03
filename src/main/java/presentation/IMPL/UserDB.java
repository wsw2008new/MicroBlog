package presentation.IMPL;

import models.UserDataEntity;
import presentation.UserDao;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by alikemal on 29.04.2016.
 */
public class UserDB extends Base implements UserDao {
    public UserDB() {
        super.getManager();
        super.getEtx();
    }

    @Override
    public List list() {
        return getManager().createQuery("Select a from UserDataEntity a ", UserDataEntity.class).getResultList();
    }

    @Override
    public void insert(UserDataEntity user) {
        persist(user);
    }

    @Override
    public void delete(int id) {
        getEtx().begin();
        getManager().remove(findUser(id));
        getEtx().commit();
    }

    @Override
    public void update(UserDataEntity user) {
        getEtx().begin();
        Query query = getManager().createQuery(
                "UPDATE UserDataEntity SET userFirstName = ?1,userLastName= ?2, userNickName= ?3 ,dateOfBirth= ?4,usePermission=?5,userPoint=?6,userSifre=?7" +
                        "WHERE userId = ?8");
        query.setParameter(1, user.getUserFirstName())
                .setParameter(2, user.getUserLastName())
                .setParameter(3, user.getUserNickName())
                .setParameter(4, user.getDateOfBirth())
                .setParameter(5, user.getUsePermission())
                .setParameter(6, user.getUserPoint())
                .setParameter(7, user.getUserSifre())
                .setParameter(8, user.getUserId()).executeUpdate();
        getEtx().commit();
    }
}

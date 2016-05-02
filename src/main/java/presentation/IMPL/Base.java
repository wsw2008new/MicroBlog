package presentation.IMPL;

import models.CommentEntity;
import models.PostEntity;
import models.UserDataEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by alikemal on 23.04.2016.
 */

public abstract class Base {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
    private EntityManager manager = factory.createEntityManager();
    private EntityTransaction etx = manager.getTransaction();

    protected EntityTransaction getEtx() {
        return etx;
    }

    protected EntityManager getManager() {
        return manager;
    }

    protected void persist(Object nesne) {
        etx.begin();
        try {
            manager.persist(nesne);
            etx.commit();
        } catch (Exception e) {
            etx.rollback();
        }
    }

    protected PostEntity findPost(int id) {
        return getManager().find(PostEntity.class, id);
    }

    protected UserDataEntity findUser(int id) {
        return getManager().find(UserDataEntity.class, id);
    }

    protected CommentEntity findComment(int id) {
        return getManager().find(CommentEntity.class, id);
    }
}

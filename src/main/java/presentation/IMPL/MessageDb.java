package presentation.IMPL;

import models.MessagessEntity;
import presentation.Message;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

/**
 * Created by alikemal on 08.05.2016.
 */

public class MessageDb extends Base implements Message {

    @Override
    public List<MessagessEntity> list(int id) {
        return getManager()
                .createQuery("Select a from MessagessEntity a where a.takenId= ?1 ", MessagessEntity.class)
                .setParameter(1, id)
                .getResultList();
    }

    @Override
    public void insert(MessagessEntity msg) {
        msg.setDate((Timestamp) Calendar.getInstance().getTime());
        persist(msg);
    }

    @Override
    public void delete(int id) {
        getEtx().begin();
        getManager().remove(id);
        getEtx().commit();
    }

    @Override
    public void update(MessagessEntity msg) {
    }
}

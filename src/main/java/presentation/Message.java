package presentation;

import models.MessagessEntity;

import java.util.List;

/**
 * Created by alikemal on 08.05.2016.
 */
public interface Message {

    List<MessagessEntity> list(int id);

    void insert(MessagessEntity msg);

    void delete(int id);

    void update(MessagessEntity msg);
}

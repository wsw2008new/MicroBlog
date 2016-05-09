package models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by alikemal on 08.05.2016.
 */
@Entity
@Table(name = "Messagess", schema = "", catalog = "ali_asp")
public class MessagessEntity {
    private int msgId;
    private int takenId;
    private int senderId;
    private String msgcontent;
    private Timestamp date;

    @Basic
    @Column(name = "msgID", nullable = false)
    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    @Basic
    @Column(name = "takenID", nullable = false)
    public int getTakenId() {
        return takenId;
    }

    public void setTakenId(int takenId) {
        this.takenId = takenId;
    }

    @Basic
    @Column(name = "senderID", nullable = false)
    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    @Basic
    @Column(name = "msgcontent", nullable = true, length = 200)
    public String getMsgcontent() {
        return msgcontent;
    }

    public void setMsgcontent(String msgcontent) {
        this.msgcontent = msgcontent;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessagessEntity that = (MessagessEntity) o;

        if (msgId != that.msgId) return false;
        if (takenId != that.takenId) return false;
        if (senderId != that.senderId) return false;
        if (msgcontent != null ? !msgcontent.equals(that.msgcontent) : that.msgcontent != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = msgId;
        result = 31 * result + takenId;
        result = 31 * result + senderId;
        result = 31 * result + (msgcontent != null ? msgcontent.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}

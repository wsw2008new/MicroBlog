package models;

import javax.persistence.*;

/**
 * Created by alikemal on 02.05.2016.
 */
@Entity
@Table(name = "Emoji", schema = "", catalog = "ali_asp")
public class EmojiEntity {
    private int emojiId;
    private String emojiTitle;
    private String emojiIconUrl;
    private Integer emojiPoint;
    private Byte emojiEditable;

    @Id
    @Column(name = "Emoji_ID", nullable = false)
    public int getEmojiId() {
        return emojiId;
    }

    public void setEmojiId(int emojiId) {
        this.emojiId = emojiId;
    }

    @Basic
    @Column(name = "Emoji_Title", nullable = false, length = 100)
    public String getEmojiTitle() {
        return emojiTitle;
    }

    public void setEmojiTitle(String emojiTitle) {
        this.emojiTitle = emojiTitle;
    }

    @Basic
    @Column(name = "Emoji_IconUrl", nullable = true, length = 200)
    public String getEmojiIconUrl() {
        return emojiIconUrl;
    }

    public void setEmojiIconUrl(String emojiIconUrl) {
        this.emojiIconUrl = emojiIconUrl;
    }

    @Basic
    @Column(name = "Emoji_Point", nullable = true)
    public Integer getEmojiPoint() {
        return emojiPoint;
    }

    public void setEmojiPoint(Integer emojiPoint) {
        this.emojiPoint = emojiPoint;
    }

    @Basic
    @Column(name = "Emoji_Editable", nullable = true)
    public Byte getEmojiEditable() {
        return emojiEditable;
    }

    public void setEmojiEditable(Byte emojiEditable) {
        this.emojiEditable = emojiEditable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmojiEntity that = (EmojiEntity) o;

        if (emojiId != that.emojiId) return false;
        if (emojiTitle != null ? !emojiTitle.equals(that.emojiTitle) : that.emojiTitle != null) return false;
        if (emojiIconUrl != null ? !emojiIconUrl.equals(that.emojiIconUrl) : that.emojiIconUrl != null) return false;
        if (emojiPoint != null ? !emojiPoint.equals(that.emojiPoint) : that.emojiPoint != null) return false;
        if (emojiEditable != null ? !emojiEditable.equals(that.emojiEditable) : that.emojiEditable != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = emojiId;
        result = 31 * result + (emojiTitle != null ? emojiTitle.hashCode() : 0);
        result = 31 * result + (emojiIconUrl != null ? emojiIconUrl.hashCode() : 0);
        result = 31 * result + (emojiPoint != null ? emojiPoint.hashCode() : 0);
        result = 31 * result + (emojiEditable != null ? emojiEditable.hashCode() : 0);
        return result;
    }
}

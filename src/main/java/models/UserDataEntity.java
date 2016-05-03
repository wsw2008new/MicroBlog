package models;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by alikemal on 02.05.2016.
 */
@Entity
@Table(name = "User_Data", schema = "", catalog = "ali_asp")
public class UserDataEntity {
    private int userId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userSifre;
    private String userNickName;
    private Integer userPoint;
    private Date dateOfBirth;
    private Boolean usePermission;

    @Id
    @Column(name = "User_Id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "User_FirstName", nullable = true, length = 30)
    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    @Basic
    @Column(name = "User_LastName", nullable = true, length = 30)
    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    @Basic
    @Column(name = "User_Email", nullable = false, length = 50)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "User_Sifre", nullable = true, length = 30)
    public String getUserSifre() {
        return userSifre;
    }

    public void setUserSifre(String userSifre) {
        this.userSifre = userSifre;
    }

    @Basic
    @Column(name = "User_NickName", nullable = true, length = 30)
    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    @Basic
    @Column(name = "User_Point", nullable = true)
    public Integer getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(Integer userPoint) {
        this.userPoint = userPoint;
    }

    @Basic
    @Column(name = "Date_of_Birth", nullable = true)
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "Use_Permission", nullable = true)
    public Boolean getUsePermission() {
        return usePermission;
    }

    public void setUsePermission(Boolean usePermission) {
        this.usePermission = usePermission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDataEntity that = (UserDataEntity) o;

        if (userId != that.userId) return false;
        if (userFirstName != null ? !userFirstName.equals(that.userFirstName) : that.userFirstName != null)
            return false;
        if (userLastName != null ? !userLastName.equals(that.userLastName) : that.userLastName != null) return false;
        if (userEmail != null ? !userEmail.equals(that.userEmail) : that.userEmail != null) return false;
        if (userSifre != null ? !userSifre.equals(that.userSifre) : that.userSifre != null) return false;
        if (userNickName != null ? !userNickName.equals(that.userNickName) : that.userNickName != null) return false;
        if (userPoint != null ? !userPoint.equals(that.userPoint) : that.userPoint != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth != null) return false;
        if (usePermission != null ? !usePermission.equals(that.usePermission) : that.usePermission != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userFirstName != null ? userFirstName.hashCode() : 0);
        result = 31 * result + (userLastName != null ? userLastName.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userSifre != null ? userSifre.hashCode() : 0);
        result = 31 * result + (userNickName != null ? userNickName.hashCode() : 0);
        result = 31 * result + (userPoint != null ? userPoint.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (usePermission != null ? usePermission.hashCode() : 0);
        return result;
    }
}

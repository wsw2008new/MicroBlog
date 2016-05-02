package view.IMPL;

import presentation.IMPL.CommentDB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.ResultSet;

/**
 * Created by alikemal on 14.04.2016.
 */
@ManagedBean(name = "comment")
@RequestScoped

public class Comment extends BaseBusiness {
    final private CommentDB commentDB = new CommentDB();


    public ResultSet list() {
        return null;
    }


    public String insert() {
        return null;
    }


    public String delete() {
        return null;
    }


    public String update() {
        return null;
    }

}

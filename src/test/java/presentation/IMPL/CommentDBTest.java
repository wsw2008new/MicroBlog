package presentation.IMPL;

import models.CommentEntity;
import org.junit.Test;

/**
 * Created by alikemal on 10.05.2016.
 */
public class CommentDBTest {
    @Test
    public void insert() throws Exception {
        CommentEntity comment = new CommentEntity();
        comment.setCommentAuthor(9);
        comment.setCommentPostid(16);
        comment.setCommentContent("test yorumu");
        new CommentDB().insert(comment);
    }

}
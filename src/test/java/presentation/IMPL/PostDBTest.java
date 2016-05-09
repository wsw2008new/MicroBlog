package presentation.IMPL;

import models.PostEntity;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alikemal on 09.05.2016.
 */
public class PostDBTest {
    @Test
    public void insertTest() throws Exception {
        PostEntity post=new PostEntity();
        post.setPostAuther(9);
        post.setPostTitle("denemebaslık");
        post.setPostContent("içerik");
        PostDB.class.newInstance().insert(post);
    }

}
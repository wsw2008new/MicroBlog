package com.microblog.Mongorepo;

import com.microblog.model.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends GenericRepository<Post, String> {
	Post findPostById(String id);

	void deletePostById(String id);
}

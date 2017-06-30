package com.microblog.repo;

import com.microblog.domain.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends GenericRepository<Post, String> {
	Post findPostById(String id);

	void deletePostById(String id);
}

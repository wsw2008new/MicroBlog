package com.microblog.service;

import com.microblog.domain.Post;

public interface PostService {

	Post findPostById(String id);

	void deletePostById(String id);
}

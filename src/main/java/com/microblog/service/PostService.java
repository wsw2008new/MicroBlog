package com.microblog.service;

import com.microblog.model.Post;

import java.util.List;

public interface PostService {

	void insert(Post post);

	void save(Post post);

	void delete(Post post);

	List<Post> findAll();

	Post findPostById(String id);

	void deletePostById(String id);
}

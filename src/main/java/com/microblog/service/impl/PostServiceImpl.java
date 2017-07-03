package com.microblog.service.impl;

import com.microblog.domain.Post;
import com.microblog.repo.PostRepository;
import com.microblog.service.PostService;
import org.springframework.stereotype.Component;

@Component(value = "postServiceImpl")
public class PostServiceImpl extends GenericServiceImpl<Post, String> implements PostService {
	private PostRepository postRepository;

	public PostServiceImpl(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public Post findPostById(String id) {
		return postRepository.findPostById(id);
	}

	@Override
	public void deletePostById(String id) {
		postRepository.deletePostById(id);
	}
}

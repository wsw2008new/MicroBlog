package com.microblog.controller;

import com.microblog.domain.Post;
import com.microblog.service.PostService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Qualifier("postServiceImpl")
	private final PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllPosts() {
		List<Post> allPosts = postService.findAll();
		return new ResponseEntity<>(allPosts, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> getPostById(@PathVariable String id) {
		Post post = postService.findPostById(id);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> addNewPost(@RequestBody Post post) {
		postService.save(post);
		return new ResponseEntity<>(post.getTitle(), HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletePostById(@PathVariable String id) {
		postService.deletePostById(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
}

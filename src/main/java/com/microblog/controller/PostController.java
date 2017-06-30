package com.microblog.controller;

import com.microblog.domain.Post;
import com.microblog.dto.PostDTO;
import com.microblog.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	private final PostServiceImpl postService;

	@Autowired
	public PostController(PostServiceImpl postService) {
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
	public ResponseEntity<String> addNewPost(@RequestBody PostDTO postDTO) {
		Post post = toPost(postDTO);
		postService.save(post);
		return new ResponseEntity<>(postDTO.getTitle(), HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletePostById(@PathVariable String id) {
		postService.deletePostById(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	private Post toPost(PostDTO postDTO) {
		Post post = new Post();
		post.setTitle(postDTO.getTitle());
		post.setSubtitle(postDTO.getSubtitle());
		post.setContent(postDTO.getContent());
		post.setDate(LocalDate.now().toString());
		post.setAuthor(postDTO.getAuthor());
		return post;
	}
}

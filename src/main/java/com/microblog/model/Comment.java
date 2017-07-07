package com.microblog.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
public class Comment extends GenericModel {

	private String author;

	private String review;

	private Post post;

	public Comment(String author, String review, Post post) {
		this.author = author;
		this.review = review;
		this.post = post;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}

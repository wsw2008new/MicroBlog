package com.microblog.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
public class Comment extends GenericModel {

	private String author;

	private String review;

	private String date;

	private String postId;

	public Comment(String author, String review, String date) {
		this.author = author;
		this.review = review;
		this.date = date;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}
}

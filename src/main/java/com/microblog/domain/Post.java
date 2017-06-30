package com.microblog.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "posts")
public class Post extends BaseModel {

	@Id
	private String id;

	private String title;

	private String subtitle;

	private String content;

	private String date;

	private String author;

	@DBRef
	private List<Comment> commentList;

	public Post(String title, String subtitle, String content, String date, String author) {
		this.title = title;
		this.subtitle = subtitle;
		this.content = content;
		this.date = date;
		this.author = author;
	}

	public Post() {
	}

	@Override
	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return "Post{" +
			"id='" + id + '\'' +
			", title='" + title + '\'' +
			", subtitle='" + subtitle + '\'' +
			", content='" + content + '\'' +
			", date='" + date + '\'' +
			", author='" + author + '\'' +
			", commentList=" + commentList +
			'}';
	}
}

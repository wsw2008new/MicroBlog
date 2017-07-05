package com.microblog.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class GenericModel {
	@Id
	private String id;

	private Date createdDate;

	private Date editedDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getEditedDate() {
		return editedDate;
	}

	public void setEditedDate(Date editedDate) {
		this.editedDate = editedDate;
	}
}

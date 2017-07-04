package com.microblog.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by Medyasoft on 25.06.2017.
 */
public class BaseModel {
	@Id
	private String id;
	private Date createdDate;

	public String getId() {
		return id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}

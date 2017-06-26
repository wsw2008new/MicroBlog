package com.microblog.domain;

import org.springframework.data.mongodb.core.index.TextIndexed;

import java.util.Map;

public class Post extends BaseModel {

	private @TextIndexed
	String content;
	private String userID;
	// list @params <mentioneduserid-mentionspostID>
	private Map<String, String> mentions;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Map<String, String> getMentions() {
		return mentions;
	}

	public void setMentions(Map<String, String> mentions) {
		this.mentions = mentions;
	}
}

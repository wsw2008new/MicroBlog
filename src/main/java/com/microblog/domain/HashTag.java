package com.microblog.domain;

import org.springframework.data.mongodb.core.index.TextIndexed;

import java.util.Map;

public class HashTag extends BaseModel {
	@TextIndexed
	private String title;
	private String startedUserID;
	private Map<String, String> mentions;

	public Map<String, String> getMentions() {
		return mentions;
	}

	public void setMentions(Map<String, String> mentions) {
		this.mentions = mentions;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStartedUserID() {
		return startedUserID;
	}

	public void setStartedUserID(String startedUserID) {
		this.startedUserID = startedUserID;
	}
}

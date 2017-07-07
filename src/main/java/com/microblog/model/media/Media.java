package com.microblog.model.media;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("media")
public class Media {
	// uploaded files goes to this folder
	private String location = "upload-dir";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}

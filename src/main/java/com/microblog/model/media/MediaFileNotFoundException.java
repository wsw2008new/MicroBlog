package com.microblog.model.media;

public class MediaFileNotFoundException extends MediaException {
	public MediaFileNotFoundException(String message) {
		super(message);
	}

	public MediaFileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}

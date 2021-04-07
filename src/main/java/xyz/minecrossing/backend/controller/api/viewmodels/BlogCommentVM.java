package xyz.minecrossing.backend.controller.api.viewmodels;

import java.time.LocalDateTime;

public class BlogCommentVM {
	private String message;
	private String username;
	private String avatar;
	private LocalDateTime createdDate;

	public BlogCommentVM() {
	}

	public BlogCommentVM(String message, String username, String avatar, LocalDateTime createdDate) {
		this.message = message;
		this.username = username;
		this.avatar = avatar;
		this.createdDate = createdDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
}
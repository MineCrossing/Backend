package xyz.minecrossing.backend.controller.api.viewmodels.builders;

import xyz.minecrossing.backend.controller.api.viewmodels.BlogCommentVM;

import java.time.LocalDateTime;

public class BlogCommentVMBuilder {
	private String message;
	private String username;
	private String avatar;
	private LocalDateTime createdDate;

	public BlogCommentVMBuilder setMessage(String message) {
		this.message = message;
		return this;
	}

	public BlogCommentVMBuilder setUsername(String username) {
		this.username = username;
		return this;
	}

	public BlogCommentVMBuilder setAvatar(String avatar) {
		this.avatar = avatar;
		return this;
	}

	public BlogCommentVMBuilder setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public BlogCommentVM build() {
		return new BlogCommentVM(message, username, avatar, createdDate);
	}
}
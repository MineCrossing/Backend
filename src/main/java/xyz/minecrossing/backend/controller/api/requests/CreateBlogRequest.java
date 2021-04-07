package xyz.minecrossing.backend.controller.api.requests;

import java.util.UUID;

public class CreateBlogRequest {
	private int userID;
	private String blogPostID = UUID.randomUUID().toString();
	private String title;
	private String subtitle;
	private String content;
	private String token;

	public CreateBlogRequest() {
	}

	public CreateBlogRequest(int userID, String title, String subtitle, String content, String token) {
		this.userID = userID;
		this.title = title;
		this.subtitle = subtitle;
		this.content = content;
		this.token = token;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getBlogPostID() {
		return blogPostID;
	}

	public void setBlogPostID(String blogPostID) {
		this.blogPostID = blogPostID;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}

package xyz.minecrossing.backend.controller.api.requests;

public class CreateBlogCommentRequest {
	private String blogPostID;
	private int userID;
	private String message;

	public CreateBlogCommentRequest() {
	}

	public CreateBlogCommentRequest(String blogPostID, int userID, String message) {
		this.blogPostID = blogPostID;
		this.userID = userID;
		this.message = message;
	}

	public String getBlogPostID() {
		return blogPostID;
	}

	public void setBlogPostID(String blogPostID) {
		this.blogPostID = blogPostID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
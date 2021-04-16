package xyz.minecrossing.backend.controller.api.requests;

/**
 * A class to store data relating to a request to create a new blog comment
 *
 * @author Matthew Dodds W18020972
 */
public class CreateBlogCommentRequest {
	private String blogPostID;
	private int userID;
	private String message;
	private String tokenID;

	public CreateBlogCommentRequest() {
	}

	public CreateBlogCommentRequest(String blogPostID, int userID, String message, String tokenID) {
		this.blogPostID = blogPostID;
		this.userID = userID;
		this.message = message;
		this.tokenID = tokenID;
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

	public String getTokenID() {
		return tokenID;
	}

	public void setTokenID(String tokenID) {
		this.tokenID = tokenID;
	}
}

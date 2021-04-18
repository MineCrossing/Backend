package xyz.minecrossing.backend.controller.api.requests;

public class DeleteBlogCommentRequest {
	private String blogCommentID;
	private String tokenID;
	private int userID;

	public DeleteBlogCommentRequest() {
	}

	public DeleteBlogCommentRequest(String blogCommentID, String tokenID, int userID) {
		this.blogCommentID = blogCommentID;
		this.tokenID = tokenID;
	}

	public String getBlogCommentID() {
		return blogCommentID;
	}

	public void setBlogCommentID(String blogCommentID) {
		this.blogCommentID = blogCommentID;
	}

	public String getTokenID() {
		return tokenID;
	}

	public void setTokenID(String tokenID) {
		this.tokenID = tokenID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
}

package xyz.minecrossing.backend.controller.api.requests;

/**
 * A class to store data relating to a request to delete a blog post
 *
 * @author Matthew Dodds W18020972
 */
public class DeleteBlogRequest {
	private int userID;
	private String blogPostID;
	private String tokenID;

	public DeleteBlogRequest() {
	}

	public DeleteBlogRequest(int userID, String blogPostID, String tokenID) {
		this.userID = userID;
		this.blogPostID = blogPostID;
		this.tokenID = tokenID;
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

	public void setBlogPostID(String id) {
		this.blogPostID = id;
	}

	public String getTokenID() {
		return tokenID;
	}

	public void setTokenID(String tokenID) {
		this.tokenID = tokenID;
	}
}

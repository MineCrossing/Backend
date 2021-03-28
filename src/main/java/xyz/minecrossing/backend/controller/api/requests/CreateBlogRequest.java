package xyz.minecrossing.backend.controller.api.requests;

public class CreateBlogRequest {
	private int userID;
	private String title;
	private String subtitle;
	private String content;

	public CreateBlogRequest() {
	}

	public CreateBlogRequest(int userID, String title, String subtitle, String content) {
		this.userID = userID;
		this.title = title;
		this.subtitle = subtitle;
		this.content = content;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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
}

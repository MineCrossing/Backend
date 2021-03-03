package xyz.minecrossing.backend.database.models;

import xyz.minecrossing.backend.database.interfaces.ColName;
import xyz.minecrossing.backend.database.interfaces.IDatabaseModel;

import java.time.LocalDateTime;

public class BlogCommentDTO implements IDatabaseModel<String> {
	@ColName(col = "blog_comment_id")
	private String blogCommentID;

	@ColName(col = "blog_post_id")
	private String blogPostID;

	@ColName(col = "user_id")
	private int userID;

	@ColName(col = "message")
	private String message;

	@ColName(col = "created_date")
	private LocalDateTime createdDate;

	public final static String BLOG_COMMENT_ID_COL = "blog_comment_id";
	public final static String BLOG_POST_ID_COL = "blog_post_id";
	public final static String USER_ID_COL = "user_id";
	public final static String MESSAGE_COL = "message";
	public final static String CREATED_DATE_COL = "created_date";

	public BlogCommentDTO() {
	}

	public BlogCommentDTO(String blogCommentID, String blogPostID, int userID, String message, LocalDateTime createdDate) {
		this.blogCommentID = blogCommentID;
		this.blogPostID = blogPostID;
		this.userID = userID;
		this.message = message;
		this.createdDate = createdDate;
	}

	public String getBlogCommentID() {
		return blogCommentID;
	}

	public void setBlogCommentID(String blogCommentID) {
		this.blogCommentID = blogCommentID;
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

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String getKey() {
		return blogCommentID;
	}
}

package xyz.minecrossing.backend.database.models;

import xyz.minecrossing.backend.database.interfaces.ColName;
import xyz.minecrossing.backend.database.interfaces.IDatabaseModel;

import java.time.LocalDateTime;

public class BlogPost implements IDatabaseModel<String> {
	@ColName(col = BLOG_POST_ID_COL)
	private String blogPostID;

	@ColName(col = USER_ID_COL)
	private int userID;

	@ColName(col = TITLE_COL)
	private String title;

	@ColName(col = SUBTITLE_COL)
	private String subtitle;

	@ColName(col = AUTHOR_COL)
	private String author;

	@ColName(col = CONTENT_COL)
	private String content;

	@ColName(col = CREATED_DATE_COL)
	private LocalDateTime createdDate;


	public final static String BLOG_POST_ID_COL = "blog_post_id";
	public final static String USER_ID_COL = "user_id";
	public final static String TITLE_COL = "title";
	public final static String SUBTITLE_COL = "subtitle";
	public final static String AUTHOR_COL = "author";
	public final static String CONTENT_COL = "content";
	public final static String CREATED_DATE_COL = "created_date";

	public BlogPost() {
	}

	public BlogPost(String blogPostID, int userID, String title, String subtitle, String author, String content, LocalDateTime createdDate) {
		this.blogPostID = blogPostID;
		this.userID = userID;
		this.title = title;
		this.subtitle = subtitle;
		this.author = author;
		this.content = content;
		this.createdDate = createdDate;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String getKey() {
		return blogPostID;
	}
}

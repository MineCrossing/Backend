package xyz.minecrossing.backend.database.builders;


import xyz.minecrossing.backend.database.models.BlogPost;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class BlogPostBuilder extends ModelBuilder<BlogPost> {
	private String blogPostID;
	private int userID;
	private String title;
	private String subtitle;
	private String author;
	private String content;
	private LocalDateTime createdDate;

	public BlogPostBuilder fromResultSet(ResultSet rs) throws SQLException {
		blogPostID = rs.getString(BlogPost.BLOG_POST_ID_COL);
		userID = rs.getInt(BlogPost.USER_ID_COL);
		title = rs.getString(BlogPost.TITLE_COL);
		subtitle = rs.getString(BlogPost.SUBTITLE_COL);
		author = rs.getString(BlogPost.AUTHOR_COL);
		content = rs.getString(BlogPost.CONTENT_COL);
		createdDate = rs.getTimestamp(BlogPost.CREATED_DATE_COL).toLocalDateTime();

		return this;
	}

	public BlogPostBuilder setBlogPostID(String blogPostID) {
		this.blogPostID = blogPostID;
		return this;
	}

	public BlogPostBuilder setUserID(int userID) {
		this.userID = userID;
		return this;
	}

	public BlogPostBuilder setTitle(String title) {
		this.title = title;
		return this;
	}

	public BlogPostBuilder setSubtitle(String subtitle) {
		this.subtitle = subtitle;
		return this;
	}

	public BlogPostBuilder setAuthor(String author) {
		this.author = author;
		return this;
	}

	public BlogPostBuilder setContent(String content) {
		this.content = content;
		return this;
	}

	public BlogPostBuilder setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public BlogPost build() {
		return new BlogPost(blogPostID, userID, title, subtitle, author, content, createdDate);
	}
}
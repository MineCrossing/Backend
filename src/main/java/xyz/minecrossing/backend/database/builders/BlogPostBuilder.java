package xyz.minecrossing.backend.database.builders;


import xyz.minecrossing.backend.database.models.BlogPost;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * An BlogPost model builder
 *
 * @author Matthew Dodds W18020972
 */
public class BlogPostBuilder extends ModelBuilder<BlogPost> {
	private String blogPostID;
	private int userID;
	private String title;
	private String subtitle;
	private String author;
	private String content;
	private LocalDateTime createdDate;

	/**
	 * A method to build an object from a ResultSet
	 *
	 * @param rs The ResultSet containing the data with which to create the object
	 * @return An instance of the object with data populated from the result set
	 * @throws SQLException A potential exception which can be thrown if there is an issue retrieving data from the ResultSet
	 */
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

	/**
	 * A method to build the object
	 *
	 * @return An instance of the object
	 */
	@Override
	public BlogPost build() {
		return new BlogPost(blogPostID, userID, title, subtitle, author, content, createdDate);
	}
}
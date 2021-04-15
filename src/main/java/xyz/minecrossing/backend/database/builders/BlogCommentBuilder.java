package xyz.minecrossing.backend.database.builders;


import xyz.minecrossing.backend.database.models.BlogComment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * An BlogComment model builder
 *
 * @author Matthew Dodds W18020972
 */
public class BlogCommentBuilder extends ModelBuilder<BlogComment> {
	private String blogCommentID;
	private String blogPostID;
	private int userID;
	private String message;
	private LocalDateTime createdDate;

	/**
	 * A method to build an object from a ResultSet
	 *
	 * @param rs The ResultSet containing the data with which to create the object
	 * @return An instance of the object with data populated from the result set
	 * @throws SQLException A potential exception which can be thrown if there is an issue retrieving data from the ResultSet
	 */
	public BlogCommentBuilder fromResultSet(ResultSet rs) throws SQLException {
		blogCommentID = rs.getString(BlogComment.BLOG_COMMENT_ID_COL);
		blogPostID = rs.getString(BlogComment.BLOG_POST_ID_COL);
		userID = rs.getInt(BlogComment.USER_ID_COL);
		message = rs.getString(BlogComment.MESSAGE_COL);
		createdDate = rs.getTimestamp(BlogComment.CREATED_DATE_COL).toLocalDateTime();

		return this;
	}

	public BlogCommentBuilder setBlogCommentID(String blogCommentID) {
		this.blogCommentID = blogCommentID;
		return this;
	}

	public BlogCommentBuilder setBlogPostID(String blogPostID) {
		this.blogPostID = blogPostID;
		return this;
	}

	public BlogCommentBuilder setUserID(int userID) {
		this.userID = userID;
		return this;
	}

	public BlogCommentBuilder setMessage(String message) {
		this.message = message;
		return this;
	}

	public BlogCommentBuilder setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	/**
	 * A method to build the object
	 *
	 * @return An instance of the object
	 */
	@Override
	public BlogComment build() {
		return new BlogComment(blogCommentID, blogPostID, userID, message, createdDate);
	}
}
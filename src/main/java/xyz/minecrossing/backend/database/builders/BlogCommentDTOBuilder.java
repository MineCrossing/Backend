package xyz.minecrossing.backend.database.builders;


import xyz.minecrossing.backend.database.models.BlogCommentDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class BlogCommentDTOBuilder extends DTOBuilder<BlogCommentDTO> {
	private String blogCommentID;
	private String blogPostID;
	private int userID;
	private String message;
	private LocalDateTime createdDate;

	public BlogCommentDTOBuilder fromResultSet(ResultSet rs) throws SQLException {
		blogCommentID = rs.getString(BlogCommentDTO.BLOG_COMMENT_ID_COL);
		blogPostID = rs.getString(BlogCommentDTO.BLOG_POST_ID_COL);
		userID = rs.getInt(BlogCommentDTO.USER_ID_COL);
		message = rs.getString(BlogCommentDTO.MESSAGE_COL);
		createdDate = rs.getTimestamp(BlogCommentDTO.CREATED_DATE_COL).toLocalDateTime();

		return this;
	}

	public BlogCommentDTOBuilder setBlogCommentID(String blogCommentID) {
		this.blogCommentID = blogCommentID;
		return this;
	}

	public BlogCommentDTOBuilder setBlogPostID(String blogPostID) {
		this.blogPostID = blogPostID;
		return this;
	}

	public BlogCommentDTOBuilder setUserID(int userID) {
		this.userID = userID;
		return this;
	}

	public BlogCommentDTOBuilder setMessage(String message) {
		this.message = message;
		return this;
	}

	public BlogCommentDTOBuilder setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public BlogCommentDTO build() {
		return new BlogCommentDTO(blogCommentID, blogPostID, userID, message, createdDate);
	}
}
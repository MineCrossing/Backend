package xyz.minecrossing.backend.database.builders;


import xyz.minecrossing.backend.database.models.BlogPostDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class BlogPostDTOBuilder extends DTOBuilder<BlogPostDTO> {
	private String blogPostID;
	private int userID;
	private String title;
	private String subtitle;
	private String author;
	private String content;
	private LocalDateTime createdDate;

	public BlogPostDTOBuilder fromResultSet(ResultSet rs) throws SQLException {
		blogPostID = rs.getString(BlogPostDTO.BLOG_POST_ID_COL);
		userID = rs.getInt(BlogPostDTO.USER_ID_COL);
		title = rs.getString(BlogPostDTO.TITLE_COL);
		subtitle = rs.getString(BlogPostDTO.SUBTITLE_COL);
		author = rs.getString(BlogPostDTO.AUTHOR_COL);
		content = rs.getString(BlogPostDTO.CONTENT_COL);
		createdDate = rs.getTimestamp(BlogPostDTO.CREATED_DATE_COL).toLocalDateTime();

		return this;
	}

	public BlogPostDTOBuilder setBlogPostID(String blogPostID) {
		this.blogPostID = blogPostID;
		return this;
	}

	public BlogPostDTOBuilder setUserID(int userID) {
		this.userID = userID;
		return this;
	}

	public BlogPostDTOBuilder setTitle(String title) {
		this.title = title;
		return this;
	}

	public BlogPostDTOBuilder setSubtitle(String subtitle) {
		this.subtitle = subtitle;
		return this;
	}

	public BlogPostDTOBuilder setAuthor(String author) {
		this.author = author;
		return this;
	}

	public BlogPostDTOBuilder setContent(String content) {
		this.content = content;
		return this;
	}

	public BlogPostDTOBuilder setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public BlogPostDTO build() {
		return new BlogPostDTO(blogPostID, userID, title, subtitle, author, content, createdDate);
	}
}
package xyz.minecrossing.backend.controller.api.viewmodels;

import java.time.LocalDateTime;

public class BlogPostPreview {
	private String blogPostID;
	private String title;
	private String subtitle;
	private String author;
	private LocalDateTime date;
	private String preview;
	private String content;

	public BlogPostPreview() {
	}

	public BlogPostPreview(String blogPostID, String title, String subtitle, String author, LocalDateTime date, String preview, String content) {
		this.blogPostID = blogPostID;
		this.title = title;
		this.subtitle = subtitle;
		this.author = author;
		this.date = date;
		this.preview = preview;
		this.content = content;
	}

	public String getBlogPostID() {
		return blogPostID;
	}

	public void setBlogPostID(String blogPostID) {
		this.blogPostID = blogPostID;
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}

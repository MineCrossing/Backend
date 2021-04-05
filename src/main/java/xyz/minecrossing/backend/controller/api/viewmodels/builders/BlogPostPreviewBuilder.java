package xyz.minecrossing.backend.controller.api.viewmodels.builders;

import xyz.minecrossing.backend.controller.api.viewmodels.BlogPostPreview;

import java.time.LocalDateTime;

public class BlogPostPreviewBuilder {
	private String blogPostID;
	private String title;
	private String subtitle;
	private String author;
	private LocalDateTime date;
	private String preview;
	private String content;

	public BlogPostPreviewBuilder setBlogPostID(String blogPostID) {
		this.blogPostID = blogPostID;
		return this;
	}

	public BlogPostPreviewBuilder setTitle(String title) {
		this.title = title;
		return this;
	}

	public BlogPostPreviewBuilder setSubtitle(String subtitle) {
		this.subtitle = subtitle;
		return this;
	}

	public BlogPostPreviewBuilder setAuthor(String author) {
		this.author = author;
		return this;
	}

	public BlogPostPreviewBuilder setDate(LocalDateTime date) {
		this.date = date;
		return this;
	}

	public BlogPostPreviewBuilder setPreview(String preview) {
		this.preview = preview;
		return this;
	}

	public BlogPostPreviewBuilder setContent(String content) {
		this.content = content;
		return this;
	}

	public BlogPostPreview build() {
		return new BlogPostPreview(blogPostID, title, subtitle, author, date, preview, content);
	}
}
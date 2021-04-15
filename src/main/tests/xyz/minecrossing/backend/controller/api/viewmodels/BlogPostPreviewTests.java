package xyz.minecrossing.backend.controller.api.viewmodels;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlogPostPreviewTests {
	private BlogPostPreview object;
	private final String sampleString = "123";
	private final LocalDateTime sampleDate = LocalDateTime.now();

	@BeforeEach
	void setup() {
		object = new BlogPostPreview();
	}

	@Test
	void getSetBlogPostID() {
		object.setBlogPostID(sampleString);
		assertEquals(sampleString, object.getBlogPostID());
	}

	@Test
	void getSetTitle() {
		object.setTitle(sampleString);
		assertEquals(sampleString, object.getTitle());
	}

	@Test
	void getSetSubtitle() {
		object.setSubtitle(sampleString);
		assertEquals(sampleString, object.getSubtitle());
	}

	@Test
	void getSetAuthor() {
		object.setAuthor(sampleString);
		assertEquals(sampleString, object.getAuthor());
	}

	@Test
	void getSetDate() {
		object.setDate(sampleDate);
		assertEquals(sampleDate, object.getDate());
	}

	@Test
	void getSetPreview() {
		object.setPreview(sampleString);
		assertEquals(sampleString, object.getPreview());
	}

	@Test
	void getSetContent() {
		object.setContent(sampleString);
		assertEquals(sampleString, object.getContent());
	}

}

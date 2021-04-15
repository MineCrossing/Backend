package xyz.minecrossing.backend.controller.api.viewmodels.builders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlogPostPreviewBuilderTests {
	BlogPostPreviewBuilder object;
	private final String sampleString = "123";
	private final LocalDateTime sampleDate = LocalDateTime.now();

	@BeforeEach
	void setup() {
		object = new BlogPostPreviewBuilder();
	}

	@Test
	void getSetBlogPostID() {
		object.setBlogPostID(sampleString);
		assertEquals(sampleString, object.build().getBlogPostID());
	}

	@Test
	void getSetTitle() {
		object.setTitle(sampleString);
		assertEquals(sampleString, object.build().getTitle());
	}

	@Test
	void getSetSubtitle() {
		object.setSubtitle(sampleString);
		assertEquals(sampleString, object.build().getSubtitle());
	}

	@Test
	void getSetAuthor() {
		object.setAuthor(sampleString);
		assertEquals(sampleString, object.build().getAuthor());
	}

	@Test
	void getSetDate() {
		object.setDate(sampleDate);
		assertEquals(sampleDate, object.build().getDate());
	}

	@Test
	void getSetPreview() {
		object.setPreview(sampleString);
		assertEquals(sampleString, object.build().getPreview());
	}

	@Test
	void getSetContent() {
		object.setContent(sampleString);
		assertEquals(sampleString, object.build().getContent());
	}
}

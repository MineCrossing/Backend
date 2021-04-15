package xyz.minecrossing.backend.database.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlogPostTests {
	private BlogPost object;
	private final String sampleString = "123";
	private final int sampleInt = 1;
	private final LocalDateTime sampleDate = LocalDateTime.now();

	@BeforeEach
	void setup() {
		object = new BlogPost();
	}

	@Test
	void getSetBlogPostID() {
		object.setBlogPostID(sampleString);
		assertEquals(sampleString, object.getBlogPostID());
	}

	@Test
	void getSetUserID() {
		object.setUserID(sampleInt);
		assertEquals(sampleInt, object.getUserID());
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
	void getSetContent() {
		object.setContent(sampleString);
		assertEquals(sampleString, object.getContent());
	}

	@Test
	void getSetCreatedDate() {
		object.setCreatedDate(sampleDate);
		assertEquals(sampleDate, object.getCreatedDate());
	}
}

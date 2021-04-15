package xyz.minecrossing.backend.database.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlogCommentTests {
	private BlogComment object;
	private final String sampleString = "123";
	private final int sampleInt = 1;
	private final LocalDateTime sampleDate = LocalDateTime.now();

	@BeforeEach
	void setup() {
		object = new BlogComment();
	}

	@Test
	void getSetBlogCommentID() {
		object.setBlogCommentID(sampleString);
		assertEquals(sampleString, object.getBlogCommentID());
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
	void getSetMessage() {
		object.setMessage(sampleString);
		assertEquals(sampleString, object.getMessage());
	}

	@Test
	void getSetCreatedDate() {
		object.setCreatedDate(sampleDate);
		assertEquals(sampleDate, object.getCreatedDate());
	}

}

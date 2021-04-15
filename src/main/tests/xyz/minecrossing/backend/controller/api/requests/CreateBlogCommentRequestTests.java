package xyz.minecrossing.backend.controller.api.requests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateBlogCommentRequestTests {
	private CreateBlogCommentRequest object;
	private final String sampleString = "123";
	private final int sampleInt = 1;

	@BeforeEach
	void setup() {
		object = new CreateBlogCommentRequest();
	}

	@Test
	void constructor() {
		object = new CreateBlogCommentRequest(sampleString, sampleInt, sampleString);
		assertNotNull(object);
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

}

package xyz.minecrossing.backend.controller.api.requests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeleteBlogCommentRequestTests {
	private DeleteBlogCommentRequest object;
	private final String sampleString = "123";
	private final int sampleInt = 1;

	@BeforeEach
	void setup() {
		object = new DeleteBlogCommentRequest();
	}

	@Test
	void constructor() {
		object = new DeleteBlogCommentRequest(sampleString, sampleString, sampleInt);
		assertNotNull(object);
	}

	@Test
	void getSetCommentID() {
		object.setBlogCommentID(sampleString);
		assertEquals(sampleString, object.getBlogCommentID());
	}

	@Test
	void getSetTokenID() {
		object.setTokenID(sampleString);
		assertEquals(sampleString, object.getTokenID());
	}

	@Test
	void getSetUserID() {
		object.setUserID(sampleInt);
		assertEquals(sampleInt, object.getUserID());
	}
}

package xyz.minecrossing.backend.controller.api.requests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeleteBlogRequestTests {
	private DeleteBlogRequest object;
	private final String sampleString = "123";
	private final int sampleInt = 1;

	@BeforeEach
	void setup() {
		object = new DeleteBlogRequest();
	}

	@Test
	void constructor() {
		object = new DeleteBlogRequest(sampleInt, sampleString, sampleString);
		assertNotNull(object);
	}

	@Test
	void getSetBlogPostID() {
		object.setBlogPostID(sampleString);
		assertEquals(sampleString, object.getBlogPostID());
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

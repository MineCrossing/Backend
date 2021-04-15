package xyz.minecrossing.backend.controller.api.requests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateBlogRequestTests {
	private CreateBlogRequest object;
	private final String sampleString = "123";
	private final int sampleInt = 1;

	@BeforeEach
	void setup() {
		object = new CreateBlogRequest();
	}

	@Test
	void constructor() {
		object = new CreateBlogRequest(sampleInt, sampleString, sampleString, sampleString, sampleString);
		assertNotNull(object);
	}

	@Test
	void getSetUserID() {
		object.setUserID(sampleInt);
		assertEquals(sampleInt, object.getUserID());
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
	void getSetContent() {
		object.setContent(sampleString);
		assertEquals(sampleString, object.getContent());
	}

	@Test
	void getSetToken() {
		object.setToken(sampleString);
		assertEquals(sampleString, object.getToken());
	}

}

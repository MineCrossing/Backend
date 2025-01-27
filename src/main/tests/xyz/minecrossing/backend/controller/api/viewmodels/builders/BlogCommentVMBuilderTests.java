package xyz.minecrossing.backend.controller.api.viewmodels.builders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlogCommentVMBuilderTests {
	private BlogCommentVMBuilder object;
	private final String sampleString = "123";
	private final LocalDateTime sampleDate = LocalDateTime.now();

	@BeforeEach
	void setup() {
		object = new BlogCommentVMBuilder();
	}

	@Test
	void getSetCommentID() {
		object.setBlogCommentID(sampleString);
		assertEquals(sampleString, object.build().getBlogCommentID());
	}

	@Test
	void getSetMessage() {
		object.setMessage(sampleString);
		assertEquals(sampleString, object.build().getMessage());
	}

	@Test
	void getSetUsername() {
		object.setUsername(sampleString);
		assertEquals(sampleString, object.build().getUsername());
	}

	@Test
	void getSetAvatar() {
		object.setAvatar(sampleString);
		assertEquals(sampleString, object.build().getAvatar());
	}

	@Test
	void getSetCreatedDate() {
		object.setCreatedDate(sampleDate);
		assertEquals(sampleDate, object.build().getCreatedDate());
	}
}

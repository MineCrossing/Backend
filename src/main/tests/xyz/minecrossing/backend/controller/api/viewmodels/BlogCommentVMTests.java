package xyz.minecrossing.backend.controller.api.viewmodels;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlogCommentVMTests {
	private BlogCommentVM object;
	private final String sampleString = "123";
	private final LocalDateTime sampleDate = LocalDateTime.now();

	@BeforeEach
	void setup() {
		object = new BlogCommentVM();
	}

	@Test
	void getSetMessage() {
		object.setMessage(sampleString);
		assertEquals(sampleString, object.getMessage());
	}

	@Test
	void getSetUsername() {
		object.setUsername(sampleString);
		assertEquals(sampleString, object.getUsername());
	}

	@Test
	void getSetAvatar() {
		object.setAvatar(sampleString);
		assertEquals(sampleString, object.getAvatar());
	}

	@Test
	void getSetCreatedDate() {
		object.setCreatedDate(sampleDate);
		assertEquals(sampleDate, object.getCreatedDate());
	}

}

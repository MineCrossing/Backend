package xyz.minecrossing.backend.controller.api.requests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AuthRequestTests {
	private AuthRequest object;
	private final String sampleString = "123";
	private final int sampleInt = 1;

	@BeforeEach
	void setup() {
		object = new AuthRequest();
	}

	@Test
	void constructor() {
		object = new AuthRequest(sampleInt, sampleString);
		assertNotNull(object);
	}

	@Test
	void getSetUserId() {
		object.setUserId(sampleInt);
		assertEquals(sampleInt, object.getUserId());
	}

	@Test
	void getSetToken() {
		object.setToken(sampleString);
		assertEquals(sampleString, object.getToken());
	}

}

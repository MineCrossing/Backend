package xyz.minecrossing.backend.controller.api.responses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AuthResponseTests {
	private AuthResponse object;
	private final boolean sampleBool = true;
	private final int sampleInt = 1;

	@BeforeEach
	void setup() {
		object = new AuthResponse();
	}

	@Test
	void constructor() {
		object = new AuthResponse(sampleBool, sampleBool, sampleInt);
		assertNotNull(object);
	}

	@Test
	void getSetUserID() {
		object.setUserID(sampleInt);
		assertEquals(sampleInt, object.getUserID());
	}

	@Test
	void isSetLoggedIn() {
		object.setLoggedIn(sampleBool);
		assertEquals(sampleBool, object.isLoggedIn());
	}

	@Test
	void isSetAdmin() {
		object.setAdmin(sampleBool);
		assertEquals(sampleBool, object.isAdmin());
	}

}

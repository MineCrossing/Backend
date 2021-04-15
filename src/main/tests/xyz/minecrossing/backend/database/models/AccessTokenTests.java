package xyz.minecrossing.backend.database.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccessTokenTests {
	private AccessToken object;
	private final String sampleString = "123";
	private final int sampleInt = 1;
	private final LocalDateTime sampleDate = LocalDateTime.now();

	@BeforeEach
	void setup() {
		object = new AccessToken();
	}

	@Test
	void getSetAccessTokenID() {
		object.setAccessTokenID(sampleString);
		assertEquals(sampleString, object.getAccessTokenID());
	}

	@Test
	void getSetUserID() {
		object.setUserID(sampleInt);
		assertEquals(sampleInt, object.getUserID());
	}

	@Test
	void getSetClientID() {
		object.setClientID(sampleInt);
		assertEquals(sampleInt, object.getClientID());
	}

	@Test
	void getSetTokenName() {
		object.setTokenName(sampleString);
		assertEquals(sampleString, object.getTokenName());
	}

	@Test
	void getSetScopes() {
		object.setScopes(sampleString);
		assertEquals(sampleString, object.getScopes());
	}

	@Test
	void isRevoked() {
		object.setRevoked(true);
		assertEquals(true, object.isRevoked());
	}

	@Test
	void getSetCreatedAt() {
		object.setCreatedAt(sampleDate);
		assertEquals(sampleDate, object.getCreatedAt());
	}

	@Test
	void getSetUpdatedAt() {
		object.setUpdatedAt(sampleDate);
		assertEquals(sampleDate, object.getUpdatedAt());
	}

	@Test
	void getSetExpiresAt() {
		object.setExpiresAt(sampleDate);
		assertEquals(sampleDate, object.getExpiresAt());
	}

}

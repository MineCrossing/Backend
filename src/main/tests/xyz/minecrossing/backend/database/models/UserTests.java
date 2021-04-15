package xyz.minecrossing.backend.database.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTests {
	private User object;
	private final String sampleString = "123";
	private final int sampleInt = 1;
	private final LocalDateTime sampleDate = LocalDateTime.now();

	@BeforeEach
	void setup() {
		object = new User();
	}

	@Test
	void getSetUserID() {
		object.setUserID(sampleInt);
		assertEquals(sampleInt, object.getUserID());
	}

	@Test
	void getSetRoleID() {
		object.setRoleID(sampleInt);
		assertEquals(sampleInt, object.getRoleID());
	}

	@Test
	void getSetUsername() {
		object.setUsername(sampleString);
		assertEquals(sampleString, object.getUsername());
	}

	@Test
	void getSetEmail() {
		object.setEmail(sampleString);
		assertEquals(sampleString, object.getEmail());
	}

	@Test
	void getSetPassword() {
		object.setPassword(sampleString);
		assertEquals(sampleString, object.getPassword());
	}

	@Test
	void getSetAvatarPath() {
		object.setAvatarPath(sampleString);
		assertEquals(sampleString, object.getAvatarPath());
	}

	@Test
	void getSetEmailVerifiedAt() {
		object.setEmailVerifiedAt(sampleDate);
		assertEquals(sampleDate, object.getEmailVerifiedAt());
	}

	@Test
	void getSetCreatedDate() {
		object.setCreatedDate(sampleDate);
		assertEquals(sampleDate, object.getCreatedDate());
	}

	@Test
	void getSetUpdatedDate() {
		object.setUpdatedDate(sampleDate);
		assertEquals(sampleDate, object.getUpdatedDate());
	}

	@Test
	void getSetSettings() {
		object.setSettings(sampleString);
		assertEquals(sampleString, object.getSettings());
	}

	@Test
	void getSetRememberToken() {
		object.setRememberToken(sampleString);
		assertEquals(sampleString, object.getRememberToken());
	}

}

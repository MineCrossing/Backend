package xyz.minecrossing.backend.database.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoleTests {
	private Role object;
	private final String sampleString = "123";
	private final int sampleInt = 1;
	private final LocalDateTime sampleDate = LocalDateTime.now();

	@BeforeEach
	void setup() {
		object = new Role();
	}

	@Test
	void getSetRoleID() {
		object.setRoleID(sampleInt);
		assertEquals(sampleInt, object.getRoleID());
	}

	@Test
	void getSetRoleName() {
		object.setRoleName(sampleString);
		assertEquals(sampleString, object.getRoleName());
	}

	@Test
	void getSetDisplayName() {
		object.setDisplayName(sampleString);
		assertEquals(sampleString, object.getDisplayName());
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

}

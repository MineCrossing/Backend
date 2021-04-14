package xyz.minecrossing.backend.database.resources;

import org.junit.jupiter.api.*;
import xyz.minecrossing.backend.database.builders.RoleBuilder;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RoleResourceTests {
	private RoleResource roles;
	private final int TEST_ROLE_ID = 999999999;

	@BeforeEach
	void setup() {
		roles = new RoleResource();
	}

	@Test
	@Order(1)
	void create() {
		boolean result = roles.add(new RoleBuilder()
				.setCreatedDate(LocalDateTime.now())
				.setDisplayName("name")
				.setRoleID(TEST_ROLE_ID)
				.setUpdatedDate(LocalDateTime.now())
				.setRoleName("aNewRole")
				.build()
		);

		assertTrue(result);
	}

	@Test
	@Order(2)
	void find() {
		var role = roles.find(TEST_ROLE_ID);
		assertNotNull(role);
	}

	@Test
	@Order(3)
	void update() {
		var updatedName = "newName";
		var role = roles.find(TEST_ROLE_ID);

		role.setDisplayName(updatedName);
		roles.update(role);

		role = roles.find(TEST_ROLE_ID);
		assertEquals(updatedName, role.getDisplayName());
	}

	@Test
	@Order(4)
	void delete() {
		var role = roles.find(TEST_ROLE_ID);
		var result = roles.delete(role);
		assertTrue(result);
	}
}
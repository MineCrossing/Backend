package xyz.minecrossing.backend.database.resources;

import org.junit.jupiter.api.*;
import xyz.minecrossing.backend.database.builders.UserDTOBuilder;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserResourceTests {
	private UserResource users;
	private final int TEST_USER_ID = 666888999;

	@BeforeEach
	void setup() {
		users = new UserResource();
	}

	@Test
	@Order(1)
	void create() {
		UUID id = UUID.randomUUID();
		String somewhatUniqueUsername = id.toString().substring(0, new Random().nextInt(5) + (new Random().nextInt(5)));
		System.out.println("Adding user: " + somewhatUniqueUsername);

		boolean result = users.add(new UserDTOBuilder()
				.setUserID(666888999)
				.setRoleID(1)
				.setUsername(somewhatUniqueUsername)
				.setEmail(somewhatUniqueUsername + "@fake.com")
				.setPassword("pass")
				.setAvatarPath("users/default.png")
				.setCreatedDate(LocalDateTime.now())
				.setUpdatedDate(LocalDateTime.now())
				.setEmailVerifiedAt(LocalDateTime.now())
				.build());

		assertTrue(result);
	}

	@Test
	@Order(2)
	void find() {
		var user = users.find(TEST_USER_ID);
		assertNotNull(user);
	}

	@Test
	@Order(3)
	void update() {
		var updatedEmailValue = "updated@email.com";
		var user = users.find(TEST_USER_ID);

		user.setEmail(updatedEmailValue);
		users.update(user);

		user = users.find(TEST_USER_ID);
		assertEquals(updatedEmailValue, user.getEmail());
	}

	@Test
	@Order(4)
	void delete() {
		var user = users.find(TEST_USER_ID);
		var result = users.delete(user);
		assertTrue(result);
	}
}

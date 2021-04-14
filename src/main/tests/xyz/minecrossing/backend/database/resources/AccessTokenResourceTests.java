package xyz.minecrossing.backend.database.resources;

import org.junit.jupiter.api.*;
import xyz.minecrossing.backend.database.builders.AccessTokenBuilder;
import xyz.minecrossing.backend.database.helpers.ParamSpecification;
import xyz.minecrossing.backend.database.models.AccessToken;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccessTokenResourceTests {
	private AccessTokenResource accessTokens;
	private final String TEST_ACCESS_TOKEN_ID = "99999999999";
	private final int TEST_USER_ID = 4;

	@BeforeEach
	void setup() {
		accessTokens = new AccessTokenResource();
	}

	@Test
	@Order(1)
	void create() {
		boolean result = accessTokens.add(new AccessTokenBuilder()
				.setAccessTokenID(TEST_ACCESS_TOKEN_ID)
				.setClientID(1)
				.setCreatedAt(LocalDateTime.now())
				.setExpiresAt(LocalDateTime.now().plusDays(1))
				.setRevoked(false)
				.setScopes("user")
				.setUpdatedAt(LocalDateTime.now())
				.setTokenName("123")
				.setUserID(TEST_USER_ID)
				.build()
		);

		assertTrue(result);
	}

	@Test
	@Order(2)
	void find() {
		var token = accessTokens.find(TEST_ACCESS_TOKEN_ID);
		assertNotNull(token);
	}

	@Test
	@Order(3)
	void findBy() {
		var token = accessTokens.findBy(new ParamSpecification<>(AccessToken.ACCESS_TOKEN_ID_COL, TEST_ACCESS_TOKEN_ID));
		assertNotNull(token);
	}

	@Test
	@Order(4)
	void update() {
		var updatedDate = LocalDateTime.now();
		var token = accessTokens.find(TEST_ACCESS_TOKEN_ID);

		token.setUpdatedAt(updatedDate);
		accessTokens.update(token);

		token = accessTokens.find(TEST_ACCESS_TOKEN_ID);
		assertEquals(updatedDate.withNano(0), token.getUpdatedAt().withNano(0));
	}

	@Test
	@Order(5)
	void validate() {
		assertTrue(accessTokens.validate(TEST_ACCESS_TOKEN_ID, TEST_USER_ID));
	}

	@Test
	@Order(6)
	void revoke() {
		var token = accessTokens.find(TEST_ACCESS_TOKEN_ID);
		assertTrue(accessTokens.revoke(token));
	}


	@Test
	@Order(7)
	void delete() {
		var token = accessTokens.find(TEST_ACCESS_TOKEN_ID);
		var result = accessTokens.delete(token);
		assertTrue(result);
	}
}

package xyz.minecrossing.backend.database.resources;

import org.junit.jupiter.api.*;
import xyz.minecrossing.backend.database.builders.PlayerBuilder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlayerResourceTests {
	private PlayerResource players;
	private final String TEST_PLAYER_ID = "999999999";

	@BeforeEach
	void setup() {
		players = new PlayerResource();
	}

	@Test
	@Order(1)
	void create() {
		boolean result = players.addOrUpdate(new PlayerBuilder()
				.setDeaths(1)
				.setKills(1)
				.setLevel(1)
				.setLogins(1)
				.setLosses(1)
				.setName("name")
				.setPlayerID(TEST_PLAYER_ID)
				.setQuests(1)
				.setTime(45646)
				.setWins(1)
				.build()
		);

		assertTrue(result);
	}

	@Test
	@Order(2)
	void find() {
		var player = players.find(TEST_PLAYER_ID);
		assertNotNull(player);
	}

	@Test
	@Order(3)
	void update() {
		var updatedName = "newName";
		var player = players.find(TEST_PLAYER_ID);

		player.setName(updatedName);
		players.update(player);

		player = players.find(TEST_PLAYER_ID);
		assertEquals(updatedName, player.getName());
	}

	@Test
	@Order(4)
	void delete() {
		var player = players.find(TEST_PLAYER_ID);
		var result = players.delete(player);
		assertTrue(result);
	}

	@Test
	@Order(5)
	void findAll() {
		var player = players.findAll();
		assertNotNull(player);
	}
}

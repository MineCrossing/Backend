package xyz.minecrossing.backend.database.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTests {
	private Player object;
	private final String sampleString = "123";
	private final int sampleInt = 1;

	@BeforeEach
	void setup() {
		object = new Player();
	}

	@Test
	void getSetPlayerID() {
		object.setPlayerID(sampleString);
		assertEquals(sampleString, object.getPlayerID());
	}

	@Test
	void getSetName() {
		object.setName(sampleString);
		assertEquals(sampleString, object.getName());
	}

	@Test
	void getSetTime() {
		object.setTime(sampleInt);
		assertEquals(sampleInt, object.getTime());
	}

	@Test
	void getSetLevel() {
		object.setLevel(sampleInt);
		assertEquals(sampleInt, object.getLevel());
	}

	@Test
	void getSetKills() {
		object.setKills(sampleInt);
		assertEquals(sampleInt, object.getKills());
	}

	@Test
	void getSetDeaths() {
		object.setDeaths(sampleInt);
		assertEquals(sampleInt, object.getDeaths());
	}

	@Test
	void getSetWins() {
		object.setWins(sampleInt);
		assertEquals(sampleInt, object.getWins());
	}

	@Test
	void getSetLosses() {
		object.setLosses(sampleInt);
		assertEquals(sampleInt, object.getLosses());
	}

	@Test
	void getSetLogins() {
		object.setLogins(sampleInt);
		assertEquals(sampleInt, object.getLogins());
	}

	@Test
	void getSetQuests() {
		object.setQuests(sampleInt);
		assertEquals(sampleInt, object.getQuests());
	}


}

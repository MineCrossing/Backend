package xyz.minecrossing.backend.database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MineCrossingDBTests {
	@Test
	void initialise() {
		assertNotNull(MineCrossingDB.getInstance());
	}
}

package xyz.minecrossing.backend;

import xyz.minecrossing.backend.database.DBTest;
import xyz.minecrossing.backend.database.QueryBuilderTests;

import java.util.logging.Level;
import java.util.logging.Logger;


// For testing random code
public class TestApp {
	public static void main(String[] args) {
		Logger.getLogger("com.zaxxer.hikari.HikariConfig").setLevel(Level.OFF);
		QueryBuilderTests.runTests();
		DBTest.runTests();
	}
}

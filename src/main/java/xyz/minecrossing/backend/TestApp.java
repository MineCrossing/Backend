package xyz.minecrossing.backend;

import xyz.minecrossing.backend.database.MineCrossingDB;

import java.util.logging.Level;
import java.util.logging.Logger;


// For testing random code
public class TestApp {
	public static void main(String[] args) {
		Logger.getLogger("com.zaxxer.hikari.HikariConfig").setLevel(Level.OFF);
		/*QueryBuilderTests.runTests();
		DBTest.runTests();*/
		var accessToken = MineCrossingDB.getInstance().AccessTokens.find("162fcce65da9feaba93b3abf07ef105cc63d76b2359dee5c6f4cc01e24d5ba8f1b16556eda689ded");
		System.out.println(accessToken.getAccessTokenID());
	}
}

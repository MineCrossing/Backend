package xyz.minecrossing.backend;

import xyz.minecrossing.backend.database.DBTest;

// For testing random code
public class TestApp {
	public static void main(String[] args) {
		DBTest.runTests();
		System.out.println("woo");
	}
}

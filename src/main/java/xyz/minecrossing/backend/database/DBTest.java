package xyz.minecrossing.backend.database;


import xyz.minecrossing.coreutilities.dbmodels.User;
import xyz.minecrossing.coreutilities.dbmodels.builders.UserBuilder;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

public class DBTest {
	static MineCrossingDB db = MineCrossingDB.getInstance();

	public static void runTests() {
		addUser();
		findUser();
		getUsers();
	}

	public static void addUser() {
		UUID id = UUID.randomUUID();
		String somewhatUniqueUsername = id.toString().substring(0, new Random().nextInt(5) + (new Random().nextInt(5)));
		System.out.println("Adding user: " + somewhatUniqueUsername);

		boolean result = db.Users.Add(new UserBuilder()
				.setAdmin(false)
				.setCreatedDate(LocalDate.now())
				.setEmail(somewhatUniqueUsername + "@fake.com")
				.setPassword("pass")
				.setUserID(id)
				.setUsername(somewhatUniqueUsername)
				.build());

		System.out.println(result ? "Successfully added user" : "Failed to add user");
		System.out.println();
	}

	public static void findUser() {
		String id = "05f8d3ed-7b8a-4a74-8bb5-6176b52c88ec";
		System.out.println("Finding user with ID: " + id);

		User user = db.Users.Find(id);

		System.out.println(user == null ? "Failed to find user" : "Found user: " + user.getUsername());
		System.out.println();
	}

	public static void getUsers() {
		System.out.println("Finding Users...");
		System.out.println("Found " + db.Users.getAll().size() + " total users.");
		System.out.println();
	}

}
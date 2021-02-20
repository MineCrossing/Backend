package xyz.minecrossing.backend.database;

import xyz.minecrossing.backend.database.interfaces.IUserResource;
import xyz.minecrossing.backend.database.resources.UserResource;

public class MineCrossingDB {
	final public IUserResource Users;

	private static MineCrossingDB instance;

	private MineCrossingDB() {
		Users = new UserResource();
	}

	public static MineCrossingDB getInstance() {
		if (instance == null)
			instance = new MineCrossingDB();

		return instance;
	}
}

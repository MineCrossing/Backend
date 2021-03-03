package xyz.minecrossing.backend.database;

import xyz.minecrossing.backend.database.interfaces.*;
import xyz.minecrossing.backend.database.resources.*;

public class MineCrossingDB {
	public final IUserResource Users;
	public final IBlogPostResource BlogPosts;
	public final IBlogCommentResource BlogComments;
	public final IRoleResource Roles;
	public final IPlayerResource Players;

	private static MineCrossingDB instance;

	private MineCrossingDB() {
		Users = new UserResource();
		BlogPosts = new BlogPostResource();
		BlogComments = new BlogCommentResource();
		Roles = new RoleResource();
		Players = new PlayerResource();
	}

	public static MineCrossingDB getInstance() {
		if (instance == null)
			instance = new MineCrossingDB();

		return instance;
	}
}

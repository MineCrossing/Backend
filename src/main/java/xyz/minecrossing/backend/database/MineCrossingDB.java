package xyz.minecrossing.backend.database;

import xyz.minecrossing.backend.database.interfaces.IBlogCommentResource;
import xyz.minecrossing.backend.database.interfaces.IBlogPostResource;
import xyz.minecrossing.backend.database.interfaces.IRoleResource;
import xyz.minecrossing.backend.database.interfaces.IUserResource;
import xyz.minecrossing.backend.database.resources.BlogCommentResource;
import xyz.minecrossing.backend.database.resources.BlogPostResource;
import xyz.minecrossing.backend.database.resources.RoleResource;
import xyz.minecrossing.backend.database.resources.UserResource;

public class MineCrossingDB {
	public final IUserResource Users;
	public final IBlogPostResource BlogPosts;
	public final IBlogCommentResource BlogComments;
	public final IRoleResource Roles;

	private static MineCrossingDB instance;

	private MineCrossingDB() {
		Users = new UserResource();
		BlogPosts = new BlogPostResource();
		BlogComments = new BlogCommentResource();
		Roles = new RoleResource();
	}

	public static MineCrossingDB getInstance() {
		if (instance == null)
			instance = new MineCrossingDB();

		return instance;
	}
}

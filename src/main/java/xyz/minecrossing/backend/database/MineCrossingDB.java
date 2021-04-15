package xyz.minecrossing.backend.database;

import xyz.minecrossing.backend.database.interfaces.*;
import xyz.minecrossing.backend.database.resources.*;

/**
 * A store of ICRUDResources which allow for accessing the MineCrossing database
 *
 * @author Matthew Dodds W18020972
 */
public class MineCrossingDB {
	public final IUserResource Users;
	public final IBlogPostResource BlogPosts;
	public final IBlogCommentResource BlogComments;
	public final IRoleResource Roles;
	public final IPlayerResource Players;
	public final IAccessTokenResource AccessTokens;

	private static MineCrossingDB instance;

	private MineCrossingDB() {
		Users = new UserResource();
		BlogPosts = new BlogPostResource();
		BlogComments = new BlogCommentResource();
		Roles = new RoleResource();
		Players = new PlayerResource();
		AccessTokens = new AccessTokenResource();
	}

	/**
	 * Returns an instance of the database class
	 *
	 * @return An instance of the database class
	 */
	public static MineCrossingDB getInstance() {
		if (instance == null)
			instance = new MineCrossingDB();

		return instance;
	}
}

package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.builders.ModelBuilder;
import xyz.minecrossing.backend.database.builders.UserBuilder;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IUserResource;
import xyz.minecrossing.backend.database.models.User;

/**
 * An implementation of IUserResource
 *
 * @author Matthew Dodds W18020972
 */
public class UserResource extends MineCrossingStoreResource<User, Integer> implements IUserResource {

	public UserResource() {
	}

	protected QueryBuilder queryBuilder() {
		return new QueryBuilder("users");
	}

	@Override
	protected ModelBuilder<User> modelBuilder() {
		return new UserBuilder();
	}

	/**
	 * Find an object by ID
	 *
	 * @param id The ID to search by
	 * @return An object if a match is found, null otherwise
	 */
	@Override
	public User find(Integer id) {
		return find(User.USER_ID_COL, id);
	}
}

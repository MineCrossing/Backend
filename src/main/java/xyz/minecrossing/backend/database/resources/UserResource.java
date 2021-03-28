package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.builders.ModelBuilder;
import xyz.minecrossing.backend.database.builders.UserBuilder;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IUserResource;
import xyz.minecrossing.backend.database.models.User;


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

	@Override
	public User find(Integer id) {
		return find(User.USER_ID_COL, id);
	}
}

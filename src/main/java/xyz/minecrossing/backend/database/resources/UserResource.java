package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.helpers.EntityToPreparedStatementMapper;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IUserResource;
import xyz.minecrossing.coreutilities.dbmodels.User;
import xyz.minecrossing.coreutilities.dbmodels.builders.UserBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserResource extends MineCrossingResource<User> implements IUserResource {

	public UserResource() {
	}

	protected QueryBuilder queryBuilder() {
		return new QueryBuilder("users");
	}

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<>();

		try {
			ResultSet resultSet = getConnection()
					.prepareStatement(queryBuilder().select().build())
					.executeQuery();

			while (resultSet.next())
				users.add(new UserBuilder().fromResultSet(resultSet).build());

		} catch (Exception throwables) {
			throwables.printStackTrace();
		}

		return users;
	}

	/**
	 * Updates an entire user record
	 *
	 * @param user Contains the data to be updated
	 * @return True on success, false on exception
	 */
	@Override
	public boolean update(User user) {
		try {
			var columnsToUpdate = user
					.getColumnNames()
					.stream()
					.filter(c -> !c.equals(User.USER_ID_COL))
					.collect(Collectors.toList());

			var ps = new EntityToPreparedStatementMapper<>(
					getNamedParamStatement(
						queryBuilder()
							.update(columnsToUpdate)
							.where(User.USER_ID_COL)
							.build()
					)
			).mapParams(user);

			ps.execute();
			ps.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public User find(String key) {
		try {
			var ps = new EntityToPreparedStatementMapper<>(getNamedParamStatement(queryBuilder().select().where(User.USER_ID_COL).build()))
					.mapParams(User.USER_ID_COL, key);

			var resultSet = ps.executeQuery();

			resultSet.first();

			return new UserBuilder().fromResultSet(resultSet).build();
		} catch (Exception throwables) {
			throwables.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(String key) {
		try {
			new EntityToPreparedStatementMapper<>(getNamedParamStatement(queryBuilder().delete().where(User.USER_ID_COL).build()))
					.mapParams(User.USER_ID_COL, key)
					.execute();

		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return false;
		}

		return true;
	}
}

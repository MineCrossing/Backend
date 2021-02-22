package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IUserResource;
import xyz.minecrossing.coreutilities.dbmodels.User;
import xyz.minecrossing.coreutilities.dbmodels.builders.UserBuilder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserResource extends MineCrossingResource implements IUserResource {

	public UserResource() {
	}

	private QueryBuilder queryBuilder() {
		return new QueryBuilder("users");
	}

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<>();

		try {
			ResultSet rs = getConnection()
					.prepareStatement(queryBuilder().select(new User().getColumnNames()).build())
					.executeQuery();

			while (rs.next())
				users.add(new UserBuilder().fromResultSet(rs).build());


		} catch (Exception throwables) {
			throwables.printStackTrace();
		}

		return users;
	}

	@Override
	public boolean add(User user) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(queryBuilder().insert(user.getColumnNames()).build());
			ps.setString(1, user.getUserID().toString());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getUsername());
			ps.setBoolean(5, user.isAdmin());
			ps.setDate(6, java.sql.Date.valueOf(user.getCreatedDate()));


			ps.execute();
			ps.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean update(User user) {
		try {
			var columnsToUpdate = user
					.getColumnNames()
					.stream()
					.filter(c -> !c.equals(User.USER_ID_COL))
					.collect(Collectors.toList());

			PreparedStatement ps = getConnection().prepareStatement(
					queryBuilder()
					.update(columnsToUpdate)
					.build()
			);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getUsername());
			ps.setBoolean(4, user.isAdmin());
			ps.setDate(5, java.sql.Date.valueOf(user.getCreatedDate()));


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
			PreparedStatement ps = getConnection()
					.prepareStatement(queryBuilder().select(new User().getColumnNames()).where(User.USER_ID_COL).build());

			ps.setString(1, key);
			ResultSet rs = ps.executeQuery();
			rs.first();

			return new UserBuilder().fromResultSet(rs).build();

		} catch (Exception throwables) {
			throwables.printStackTrace();
			return null;
		}
	}
}

package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.interfaces.IUserResource;
import xyz.minecrossing.coreutilities.dbmodels.User;
import xyz.minecrossing.coreutilities.dbmodels.builders.UserBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserResource extends MineCrossingResource implements IUserResource {

	public UserResource() {
	}

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<>();

		try {
			Connection con = getConnection();
			ResultSet rs = con.prepareStatement("select user_id, email, password, admin, created_date, username from users;").executeQuery();
			while (rs.next()) {
				users.add(new UserBuilder()
						.setUserID(UUID.fromString(rs.getString(1)))
						.setEmail(rs.getString(2))
						.setPassword(rs.getString(3))
						.setAdmin(rs.getBoolean(4))
						.setCreatedDate(rs.getDate(5).toLocalDate())
						.setUsername(rs.getString(6))
						.build()
				);
			}
		} catch (Exception throwables) {
			throwables.printStackTrace();
		}

		return users;
	}

	@Override
	public boolean Add(User user) {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("insert into users (user_id, email, password, admin, created_date, username) values (?, ?, ?, ?, ?, ?)");
			ps.setString(1, user.getUserID().toString());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setBoolean(4, user.isAdmin());
			ps.setDate(5, java.sql.Date.valueOf(user.getCreatedDate()));
			ps.setString(6, user.getUsername());

			ps.execute();

			ps.close();
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public <K> User Find(K key) {
		if (!(key instanceof String))
			throw new IllegalArgumentException("Key must be of type String");

		String k = (String) key;

		try {
			Connection con = getConnection();

			PreparedStatement ps = con.prepareStatement("select user_id, email, password, admin, created_date, username from users where user_id = ?;");
			ps.setString(1, k);

			ResultSet rs = ps.executeQuery();

			rs.first();
			return new UserBuilder()
					.setUserID(UUID.fromString(rs.getString(1)))
					.setEmail(rs.getString(2))
					.setPassword(rs.getString(3))
					.setAdmin(rs.getBoolean(4))
					.setCreatedDate(rs.getDate(5).toLocalDate())
					.setUsername(rs.getString(6))
					.build();

		} catch (Exception throwables) {
			throwables.printStackTrace();
			return null;
		}
	}
}

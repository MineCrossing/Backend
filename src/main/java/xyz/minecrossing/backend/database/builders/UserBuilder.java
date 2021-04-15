package xyz.minecrossing.backend.database.builders;


import xyz.minecrossing.backend.database.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * An User model builder
 *
 * @author Matthew Dodds W18020972
 */
public class UserBuilder extends ModelBuilder<User> {
	private int userID;
	private int roleID;
	private String username;
	private String email;
	private String password;
	private String avatarPath;
	private LocalDateTime emailVerifiedAt;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	private String settings;
	private String rememberToken;

	/**
	 * A method to build an object from a ResultSet
	 *
	 * @param rs The ResultSet containing the data with which to create the object
	 * @return An instance of the object with data populated from the result set
	 * @throws SQLException A potential exception which can be thrown if there is an issue retrieving data from the ResultSet
	 */
	public UserBuilder fromResultSet(ResultSet rs) throws SQLException {
		Timestamp createdDate =  rs.getTimestamp(User.CREATED_DATE_COL);
		Timestamp updatedDate =  rs.getTimestamp(User.UPDATE_DATE_COL);
		Timestamp emailVerifiedAt =  rs.getTimestamp(User.EMAIL_VERIFIED_AT_COL);

		userID = rs.getInt(User.USER_ID_COL);
		roleID = rs.getInt(User.ROLE_ID_COL);
		username = rs.getString(User.USERNAME_COL);
		email = rs.getString(User.EMAIL_COL);
		password = rs.getString(User.PASSWORD_COL);
		avatarPath = rs.getString(User.AVATAR_COL);
		this.emailVerifiedAt = createdDate == null ? null : createdDate.toLocalDateTime();
		this.createdDate = updatedDate == null ? null : updatedDate.toLocalDateTime();
		this.updatedDate = emailVerifiedAt == null ? null : emailVerifiedAt.toLocalDateTime();
		settings = rs.getString(User.SETTINGS_COL);
		rememberToken = rs.getString(User.REMEMBER_TOKEN_COL);

		return this;
	}

	public UserBuilder setUserID(int userID) {
		this.userID = userID;
		return this;
	}

	public UserBuilder setRoleID(int roleID) {
		this.roleID = roleID;
		return this;
	}

	public UserBuilder setUsername(String username) {
		this.username = username;
		return this;
	}

	public UserBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public UserBuilder setPassword(String password) {
		this.password = password;
		return this;
	}

	public UserBuilder setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
		return this;
	}

	public UserBuilder setEmailVerifiedAt(LocalDateTime emailVerifiedAt) {
		this.emailVerifiedAt = emailVerifiedAt;
		return this;
	}

	public UserBuilder setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public UserBuilder setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
		return this;
	}

	public UserBuilder setSettings(String settings) {
		this.settings = settings;
		return this;
	}

	public UserBuilder setRememberToken(String rememberToken) {
		this.rememberToken = rememberToken;
		return this;
	}

	/**
	 * A method to build the object
	 *
	 * @return An instance of the object
	 */
	@Override
	public User build() {
		return new User(userID, roleID, username, email, password, avatarPath, emailVerifiedAt, createdDate, updatedDate, settings, rememberToken);
	}
}
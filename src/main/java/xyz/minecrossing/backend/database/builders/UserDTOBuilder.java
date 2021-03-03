package xyz.minecrossing.backend.database.builders;


import xyz.minecrossing.backend.database.models.UserDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class UserDTOBuilder extends DTOBuilder<UserDTO> {
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

	public UserDTOBuilder fromResultSet(ResultSet rs) throws SQLException {
		Timestamp createdDate =  rs.getTimestamp(UserDTO.CREATED_DATE_COL);
		Timestamp updatedDate =  rs.getTimestamp(UserDTO.UPDATE_DATE_COL);
		Timestamp emailVerifiedAt =  rs.getTimestamp(UserDTO.EMAIL_VERIFIED_AT_COL);

		userID = rs.getInt(UserDTO.USER_ID_COL);
		roleID = rs.getInt(UserDTO.ROLE_ID_COL);
		username = rs.getString(UserDTO.USERNAME_COL);
		email = rs.getString(UserDTO.EMAIL_COL);
		password = rs.getString(UserDTO.PASSWORD_COL);
		avatarPath = rs.getString(UserDTO.AVATAR_COL);
		this.emailVerifiedAt = createdDate == null ? null : createdDate.toLocalDateTime();
		this.createdDate = updatedDate == null ? null : updatedDate.toLocalDateTime();
		this.updatedDate = emailVerifiedAt == null ? null : emailVerifiedAt.toLocalDateTime();
		settings = rs.getString(UserDTO.SETTINGS_COL);
		rememberToken = rs.getString(UserDTO.REMEMBER_TOKEN_COL);

		return this;
	}

	public UserDTOBuilder setUserID(int userID) {
		this.userID = userID;
		return this;
	}

	public UserDTOBuilder setRoleID(int roleID) {
		this.roleID = roleID;
		return this;
	}

	public UserDTOBuilder setUsername(String username) {
		this.username = username;
		return this;
	}

	public UserDTOBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public UserDTOBuilder setPassword(String password) {
		this.password = password;
		return this;
	}

	public UserDTOBuilder setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
		return this;
	}

	public UserDTOBuilder setEmailVerifiedAt(LocalDateTime emailVerifiedAt) {
		this.emailVerifiedAt = emailVerifiedAt;
		return this;
	}

	public UserDTOBuilder setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public UserDTOBuilder setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
		return this;
	}

	public UserDTOBuilder setSettings(String settings) {
		this.settings = settings;
		return this;
	}

	public UserDTOBuilder setRememberToken(String rememberToken) {
		this.rememberToken = rememberToken;
		return this;
	}

	public UserDTO build() {
		return new UserDTO(userID, roleID, username, email, password, avatarPath, emailVerifiedAt, createdDate, updatedDate, settings, rememberToken);
	}
}
package xyz.minecrossing.backend.database.models;

import xyz.minecrossing.backend.database.interfaces.ColName;
import xyz.minecrossing.backend.database.interfaces.IDatabaseModel;

import java.time.LocalDateTime;

public class UserDTO implements IDatabaseModel<Integer> {
	@ColName(col = "id")
	private int userID;
	@ColName(col = "role_id")
	private int roleID;
	@ColName(col = "name")
	private String username;
	@ColName(col = "email")
	private String email;
	@ColName(col = "password")
	private String password;
	@ColName(col = "avatar")
	private String avatarPath;
	@ColName(col = "email_verified_at")
	private LocalDateTime emailVerifiedAt;
	@ColName(col = "created_at")
	private LocalDateTime createdDate;
	@ColName(col = "updated_at")
	private LocalDateTime updatedDate;
	@ColName(col = "settings")
	private String settings;
	@ColName(col = "remember_token")
	private String rememberToken;


	public final static String USER_ID_COL = "id";
	public final static String ROLE_ID_COL = "role_id";
	public final static String USERNAME_COL = "name";
	public final static String EMAIL_COL = "email";
	public final static String PASSWORD_COL = "password";
	public final static String AVATAR_COL = "avatar";
	public final static String EMAIL_VERIFIED_AT_COL = "email_verified_at";
	public final static String CREATED_DATE_COL = "created_at";
	public final static String UPDATE_DATE_COL = "updated_at";
	public final static String SETTINGS_COL = "settings";
	public final static String REMEMBER_TOKEN_COL = "remember_token";

	public UserDTO() {
	}

	public UserDTO(int userID, int roleID, String username, String email, String password, String avatarPath, LocalDateTime emailVerifiedAt, LocalDateTime createdDate, LocalDateTime updatedDate, String settings, String rememberToken) {
		this.userID = userID;
		this.roleID = roleID;
		this.username = username;
		this.email = email;
		this.password = password;
		this.avatarPath = avatarPath;
		this.emailVerifiedAt = emailVerifiedAt;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.settings = settings;
		this.rememberToken = rememberToken;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatarPath() {
		return avatarPath;
	}

	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}

	public LocalDateTime getEmailVerifiedAt() {
		return emailVerifiedAt;
	}

	public void setEmailVerifiedAt(LocalDateTime emailVerifiedAt) {
		this.emailVerifiedAt = emailVerifiedAt;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getSettings() {
		return settings;
	}

	public void setSettings(String settings) {
		this.settings = settings;
	}

	public String getRememberToken() {
		return rememberToken;
	}

	public void setRememberToken(String rememberToken) {
		this.rememberToken = rememberToken;
	}

	@Override
	public Integer getKey() {
		return userID;
	}
}

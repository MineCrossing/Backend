package xyz.minecrossing.backend.database.models;

import xyz.minecrossing.backend.database.interfaces.ColName;
import xyz.minecrossing.backend.database.interfaces.IDatabaseModel;

import java.time.LocalDateTime;

/**
 * A POJO to map to the User schema
 *
 * @author Matthew Dodds W18020972
 */
public class User implements IDatabaseModel<Integer> {
	@ColName(col = USER_ID_COL)
	private int userID;
	@ColName(col = ROLE_ID_COL)
	private int roleID;
	@ColName(col = USERNAME_COL)
	private String username;
	@ColName(col = EMAIL_COL)
	private String email;
	@ColName(col = PASSWORD_COL)
	private String password;
	@ColName(col = AVATAR_COL)
	private String avatarPath;
	@ColName(col = EMAIL_VERIFIED_AT_COL)
	private LocalDateTime emailVerifiedAt;
	@ColName(col = CREATED_DATE_COL)
	private LocalDateTime createdDate;
	@ColName(col = UPDATE_DATE_COL)
	private LocalDateTime updatedDate;
	@ColName(col = SETTINGS_COL)
	private String settings;
	@ColName(col = REMEMBER_TOKEN_COL)
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

	public User() {
	}

	public User(int userID, int roleID, String username, String email, String password, String avatarPath, LocalDateTime emailVerifiedAt, LocalDateTime createdDate, LocalDateTime updatedDate, String settings, String rememberToken) {
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

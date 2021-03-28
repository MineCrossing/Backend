package xyz.minecrossing.backend.database.models;

import xyz.minecrossing.backend.database.interfaces.ColName;
import xyz.minecrossing.backend.database.interfaces.IDatabaseModel;

import java.time.LocalDateTime;

public class AccessToken implements IDatabaseModel<String> {
	@ColName(col = ACCESS_TOKEN_ID_COL)
	private String accessTokenID;
	@ColName(col = USER_ID_COL)
	private int userID;
	@ColName(col = CLIENT_ID_COL)
	private int clientID;
	@ColName(col = NAME_COL)
	private String tokenName;
	@ColName(col = SCOPES_COL)
	private String scopes;
	@ColName(col = REVOKED_COL)
	private boolean revoked;
	@ColName(col = CREATED_AT_COL)
	private LocalDateTime createdAt;
	@ColName(col = UPDATED_AT_COL)
	private LocalDateTime updatedAt;
	@ColName(col = EXPIRES_AT_COL)
	private LocalDateTime expiresAt;

	public static final String ACCESS_TOKEN_ID_COL = "id";
	public static final String USER_ID_COL = "user_id";
	public static final String CLIENT_ID_COL = "client_id";
	public static final String NAME_COL = "name";
	public static final String SCOPES_COL = "scopes";
	public static final String REVOKED_COL = "revoked";
	public static final String CREATED_AT_COL = "created_at";
	public static final String UPDATED_AT_COL = "updated_at";
	public static final String EXPIRES_AT_COL = "expires_at";

	public AccessToken() {
	}

	public AccessToken(String accessTokenID, int userID, int clientID, String tokenName, String scopes, boolean revoked, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime expiresAt) {
		this.accessTokenID = accessTokenID;
		this.userID = userID;
		this.clientID = clientID;
		this.tokenName = tokenName;
		this.scopes = scopes;
		this.revoked = revoked;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.expiresAt = expiresAt;
	}

	public String getAccessTokenID() {
		return accessTokenID;
	}

	public void setAccessTokenID(String accessTokenID) {
		this.accessTokenID = accessTokenID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public String getTokenName() {
		return tokenName;
	}

	public void setTokenName(String tokenName) {
		this.tokenName = tokenName;
	}

	public String getScopes() {
		return scopes;
	}

	public void setScopes(String scopes) {
		this.scopes = scopes;
	}

	public boolean isRevoked() {
		return revoked;
	}

	public void setRevoked(boolean revoked) {
		this.revoked = revoked;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LocalDateTime getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(LocalDateTime expiresAt) {
		this.expiresAt = expiresAt;
	}

	@Override
	public String getKey() {
		return accessTokenID;
	}
}

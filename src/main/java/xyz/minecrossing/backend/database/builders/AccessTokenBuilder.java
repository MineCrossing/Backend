package xyz.minecrossing.backend.database.builders;

import xyz.minecrossing.backend.database.models.AccessToken;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AccessTokenBuilder extends ModelBuilder<AccessToken> {
	private String accessTokenID;
	private int userID;
	private int clientID;
	private String tokenName;
	private String scopes;
	private boolean revoked;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime expiresAt;

	@Override
	public ModelBuilder<AccessToken> fromResultSet(ResultSet rs) throws SQLException {
		accessTokenID = rs.getString(AccessToken.ACCESS_TOKEN_ID_COL);
		userID = rs.getInt(AccessToken.USER_ID_COL);
		clientID = rs.getInt(AccessToken.CLIENT_ID_COL);
		tokenName = rs.getString(AccessToken.NAME_COL);
		scopes = rs.getString(AccessToken.SCOPES_COL);
		revoked = rs.getBoolean(AccessToken.REVOKED_COL);
		createdAt = rs.getTimestamp(AccessToken.CREATED_AT_COL).toLocalDateTime();
		updatedAt = rs.getTimestamp(AccessToken.UPDATED_AT_COL).toLocalDateTime();
		expiresAt = rs.getTimestamp(AccessToken.EXPIRES_AT_COL).toLocalDateTime();

		return this;
	}

	public AccessTokenBuilder setAccessTokenID(String accessTokenID) {
		this.accessTokenID = accessTokenID;
		return this;
	}

	public AccessTokenBuilder setUserID(int userID) {
		this.userID = userID;
		return this;
	}

	public AccessTokenBuilder setClientID(int clientID) {
		this.clientID = clientID;
		return this;
	}

	public AccessTokenBuilder setTokenName(String tokenName) {
		this.tokenName = tokenName;
		return this;
	}

	public AccessTokenBuilder setScopes(String scopes) {
		this.scopes = scopes;
		return this;
	}

	public AccessTokenBuilder setRevoked(boolean revoked) {
		this.revoked = revoked;
		return this;
	}

	public AccessTokenBuilder setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	public AccessTokenBuilder setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}

	public AccessTokenBuilder setExpiresAt(LocalDateTime expiresAt) {
		this.expiresAt = expiresAt;
		return this;
	}

	@Override
	public AccessToken build() {
		return new AccessToken(accessTokenID, userID, clientID, tokenName, scopes, revoked, createdAt, updatedAt, expiresAt);
	}
}
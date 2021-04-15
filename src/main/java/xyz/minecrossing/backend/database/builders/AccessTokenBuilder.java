package xyz.minecrossing.backend.database.builders;

import xyz.minecrossing.backend.database.models.AccessToken;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * An AccessToken model builder
 *
 * @author Matthew Dodds W18020972
 */
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

	/**
	 * A method to build an object from a ResultSet
	 *
	 * @param rs The ResultSet containing the data with which to create the object
	 * @return An instance of the object with data populated from the result set
	 * @throws SQLException A potential exception which can be thrown if there is an issue retrieving data from the ResultSet
	 */
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

	/**
	 * A method to build the object
	 *
	 * @return An instance of the object
	 */
	@Override
	public AccessToken build() {
		return new AccessToken(accessTokenID, userID, clientID, tokenName, scopes, revoked, createdAt, updatedAt, expiresAt);
	}
}
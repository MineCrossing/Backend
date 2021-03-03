package xyz.minecrossing.backend.database.builders;

import xyz.minecrossing.backend.database.models.AccessTokenDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AccessTokenDTOBuilder extends DTOBuilder<AccessTokenDTO> {
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
	public DTOBuilder<AccessTokenDTO> fromResultSet(ResultSet rs) throws SQLException {
		accessTokenID = rs.getString(AccessTokenDTO.ACCESS_TOKEN_ID_COL);
		userID = rs.getInt(AccessTokenDTO.USER_ID_COL);
		clientID = rs.getInt(AccessTokenDTO.CLIENT_ID_COL);
		tokenName = rs.getString(AccessTokenDTO.NAME_COL);
		scopes = rs.getString(AccessTokenDTO.SCOPES_COL);
		revoked = rs.getBoolean(AccessTokenDTO.REVOKED_COL);
		createdAt = rs.getTimestamp(AccessTokenDTO.CREATED_AT_COL).toLocalDateTime();
		updatedAt = rs.getTimestamp(AccessTokenDTO.UPDATED_AT_COL).toLocalDateTime();
		expiresAt = rs.getTimestamp(AccessTokenDTO.EXPIRES_AT_COL).toLocalDateTime();

		return this;
	}

	public AccessTokenDTOBuilder setAccessTokenID(String accessTokenID) {
		this.accessTokenID = accessTokenID;
		return this;
	}

	public AccessTokenDTOBuilder setUserID(int userID) {
		this.userID = userID;
		return this;
	}

	public AccessTokenDTOBuilder setClientID(int clientID) {
		this.clientID = clientID;
		return this;
	}

	public AccessTokenDTOBuilder setTokenName(String tokenName) {
		this.tokenName = tokenName;
		return this;
	}

	public AccessTokenDTOBuilder setScopes(String scopes) {
		this.scopes = scopes;
		return this;
	}

	public AccessTokenDTOBuilder setRevoked(boolean revoked) {
		this.revoked = revoked;
		return this;
	}

	public AccessTokenDTOBuilder setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	public AccessTokenDTOBuilder setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}

	public AccessTokenDTOBuilder setExpiresAt(LocalDateTime expiresAt) {
		this.expiresAt = expiresAt;
		return this;
	}

	@Override
	public AccessTokenDTO build() {
		return new AccessTokenDTO(accessTokenID, userID, clientID, tokenName, scopes, revoked, createdAt, updatedAt, expiresAt);
	}
}
package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.builders.AccessTokenBuilder;
import xyz.minecrossing.backend.database.builders.ModelBuilder;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IAccessTokenResource;
import xyz.minecrossing.backend.database.models.AccessToken;

import java.time.LocalDateTime;

/**
 * An implementation of IAccessTokenResource
 *
 * @author Matthew Dodds W18020972
 */
public class AccessTokenResource extends MineCrossingStoreResource<AccessToken, String> implements IAccessTokenResource {
	@Override
	protected QueryBuilder queryBuilder() {
		return new QueryBuilder("oauth_access_tokens");
	}

	@Override
	protected ModelBuilder<AccessToken> modelBuilder() {
		return new AccessTokenBuilder();
	}

	/**
	 * Finds an AccessToken by ID
	 *
	 * @param id The ID to lookup by
	 * @return The found AccessToken or Null if nothing is found
	 */
	@Override
	public AccessToken find(String id) {
		return find(AccessToken.ACCESS_TOKEN_ID_COL, id);
	}

	/**
	 * Revokes a given access token
	 *
	 * @param token The AccessToken to revoke
	 * @return True on success, false on fail
	 */
	@Override
	public boolean revoke(AccessToken token) {
		if (token == null || token.isRevoked())
			return true;

		token.setRevoked(true);

		return update(token);
	}

	/**
	 * Validates that an AccessToken with a matching ID is still valid
	 *
	 * @param tokenID The ID of the AccessToken
	 * @param userID The ID of the User
	 * @return True if valid, false if not
	 */
	@Override
	public boolean validate(String tokenID, int userID) {
		var token = find(tokenID);

		if (token == null || token.isRevoked() || token.getUserID() != userID)
			return false;

		if (LocalDateTime.now().isAfter(token.getExpiresAt())) {
			revoke(token);
			return false;
		}

		return true;
	}
}

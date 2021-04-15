package xyz.minecrossing.backend.database.interfaces;

import xyz.minecrossing.backend.database.models.AccessToken;

/**
 * An interface outlining the required functionality of the AccessToken resource
 *
 * @author Matthew Dodds W18020972
 */
public interface IAccessTokenResource extends ICRUDResource<AccessToken, String> {
	/**
	 * Finds an AccessToken by ID
	 *
	 * @param id The ID to lookup by
	 * @return The found AccessToken or Null if nothing is found
	 */
	AccessToken find(String id);

	/**
	 * Revokes a given access token
	 *
	 * @param token The AccessToken to revoke
	 * @return True on success, false on fail
	 */
	boolean revoke(AccessToken token);

	/**
	 * Validates that an AccessToken with a matching ID is still valid
	 *
	 * @param tokenID The ID of the AccessToken
	 * @param userID The ID of the User
	 * @return True if valid, false if not
	 */
	boolean validate(String tokenID, int userID);
}

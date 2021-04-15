package xyz.minecrossing.backend.database.interfaces;

import xyz.minecrossing.backend.database.models.User;

/**
 * An interface outlining the required functionality of the User resource
 *
 * @author Matthew Dodds W18020972
 */
public interface IUserResource extends ICRUDResource<User, Integer>{
	/**
	 * Find an object by ID
	 *
	 * @param id The ID to search by
	 * @return An object if a match is found, null otherwise
	 */
	User find(Integer id);
}

package xyz.minecrossing.backend.database.interfaces;

import xyz.minecrossing.backend.database.models.Role;

/**
 * An interface outlining the required functionality of the Role resource
 *
 * @author Matthew Dodds W18020972
 */
public interface IRoleResource extends ICRUDResource<Role, Integer> {
	/**
	 * Find an object by ID
	 *
	 * @param id The ID to search by
	 * @return An object if a match is found, null otherwise
	 */
	Role find(Integer id);
}

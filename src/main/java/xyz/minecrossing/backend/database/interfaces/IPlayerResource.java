package xyz.minecrossing.backend.database.interfaces;

import xyz.minecrossing.backend.database.models.Player;

/**
 * An interface outlining the required functionality of the Player resource
 *
 * @author Matthew Dodds W18020972
 */
public interface IPlayerResource extends ICRUDResource<Player, String> {
	/**
	 * Find an object by ID
	 *
	 * @param id The ID to search by
	 * @return An object if a match is found, null otherwise
	 */
	Player find(String id);
}

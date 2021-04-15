package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.builders.ModelBuilder;
import xyz.minecrossing.backend.database.builders.PlayerBuilder;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IPlayerResource;
import xyz.minecrossing.backend.database.models.Player;

/**
 * An implementation of IPlayerResource
 *
 * @author Matthew Dodds W18020972
 */
public class PlayerResource extends MineCrossingResource<Player, String> implements IPlayerResource {

	@Override
	protected QueryBuilder queryBuilder() {
		return new QueryBuilder("players");
	}

	@Override
	protected ModelBuilder<Player> modelBuilder() {
		return new PlayerBuilder();
	}

	/**
	 * Find an object by ID
	 *
	 * @param id The ID to search by
	 * @return An object if a match is found, null otherwise
	 */
	@Override
	public Player find(String id) {
		return find(Player.PLAYER_ID_COL, id);
	}
}

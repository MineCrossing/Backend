package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.builders.ModelBuilder;
import xyz.minecrossing.backend.database.builders.PlayerBuilder;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IPlayerResource;
import xyz.minecrossing.backend.database.models.Player;

public class PlayerResource extends MineCrossingResource<Player, String> implements IPlayerResource {
	@Override
	public Player find(String id) {
		return find(Player.PLAYER_ID_COL, id);
	}

	@Override
	protected QueryBuilder queryBuilder() {
		return new QueryBuilder("players");
	}

	@Override
	protected ModelBuilder<Player> modelBuilder() {
		return new PlayerBuilder();
	}
}

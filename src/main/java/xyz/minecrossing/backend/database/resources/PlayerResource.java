package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.builders.DTOBuilder;
import xyz.minecrossing.backend.database.builders.PlayerDTOBuilder;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IPlayerResource;
import xyz.minecrossing.backend.database.models.PlayerDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerResource extends MineCrossingResource<PlayerDTO, String> implements IPlayerResource {
	@Override
	public PlayerDTO find(String id) {
		return find(PlayerDTO.PLAYER_ID_COL, id);
	}

	@Override
	protected QueryBuilder queryBuilder() {
		return new QueryBuilder("players");
	}

	@Override
	protected DTOBuilder<PlayerDTO> modelBuilder() {
		return new PlayerDTOBuilder();
	}

	@Override
	public List<PlayerDTO> findAll() {
		var players = new ArrayList<PlayerDTO>();

		try {
			var rs = getNamedParamStatement(queryBuilder().select().build()).executeQuery();
			while (rs.next())
				players.add(modelBuilder().fromResultSet(rs).build());

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return players;
	}
}

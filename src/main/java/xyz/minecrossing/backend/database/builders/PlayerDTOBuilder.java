package xyz.minecrossing.backend.database.builders;

import xyz.minecrossing.backend.database.models.PlayerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDTOBuilder extends DTOBuilder<PlayerDTO> {
	private String playerID;
	private String name;
	private double time;
	private int level;
	private int kills;
	private int deaths;
	private int wins;
	private int losses;
	private int logins;
	private int quests;

	@Override
	public DTOBuilder<PlayerDTO> fromResultSet(ResultSet rs) throws SQLException {
		playerID = rs.getString(PlayerDTO.PLAYER_ID_COL);
		name = rs.getString(PlayerDTO.NAME_COL);
		time = rs.getFloat(PlayerDTO.TIME_COL);
		level = rs.getInt(PlayerDTO.LEVEL_COL);
		kills = rs.getInt(PlayerDTO.KILLS_COL);
		deaths = rs.getInt(PlayerDTO.DEATHS_COL);
		wins = rs.getInt(PlayerDTO.WINS_COL);
		losses = rs.getInt(PlayerDTO.LOSSES_COL);
		logins = rs.getInt(PlayerDTO.LOGINS_COL);
		quests = rs.getInt(PlayerDTO.QUESTS_COL);

		return this;
	}

	public PlayerDTOBuilder setPlayerID(String playerID) {
		this.playerID = playerID;
		return this;
	}

	public PlayerDTOBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public PlayerDTOBuilder setTime(double time) {
		this.time = time;
		return this;
	}

	public PlayerDTOBuilder setLevel(int level) {
		this.level = level;
		return this;
	}

	public PlayerDTOBuilder setKills(int kills) {
		this.kills = kills;
		return this;
	}

	public PlayerDTOBuilder setDeaths(int deaths) {
		this.deaths = deaths;
		return this;
	}

	public PlayerDTOBuilder setWins(int wins) {
		this.wins = wins;
		return this;
	}

	public PlayerDTOBuilder setLosses(int losses) {
		this.losses = losses;
		return this;
	}

	public PlayerDTOBuilder setLogins(int logins) {
		this.logins = logins;
		return this;
	}

	public PlayerDTOBuilder setQuests(int quests) {
		this.quests = quests;
		return this;
	}

	@Override
	public PlayerDTO build() {
		return new PlayerDTO(playerID, name, time, level, kills, deaths, wins, losses, logins, quests);
	}
}
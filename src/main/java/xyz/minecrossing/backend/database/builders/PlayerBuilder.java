package xyz.minecrossing.backend.database.builders;

import xyz.minecrossing.backend.database.models.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerBuilder extends ModelBuilder<Player> {
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
	public ModelBuilder<Player> fromResultSet(ResultSet rs) throws SQLException {
		playerID = rs.getString(Player.PLAYER_ID_COL);
		name = rs.getString(Player.NAME_COL);
		time = rs.getFloat(Player.TIME_COL);
		level = rs.getInt(Player.LEVEL_COL);
		kills = rs.getInt(Player.KILLS_COL);
		deaths = rs.getInt(Player.DEATHS_COL);
		wins = rs.getInt(Player.WINS_COL);
		losses = rs.getInt(Player.LOSSES_COL);
		logins = rs.getInt(Player.LOGINS_COL);
		quests = rs.getInt(Player.QUESTS_COL);

		return this;
	}

	public PlayerBuilder setPlayerID(String playerID) {
		this.playerID = playerID;
		return this;
	}

	public PlayerBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public PlayerBuilder setTime(double time) {
		this.time = time;
		return this;
	}

	public PlayerBuilder setLevel(int level) {
		this.level = level;
		return this;
	}

	public PlayerBuilder setKills(int kills) {
		this.kills = kills;
		return this;
	}

	public PlayerBuilder setDeaths(int deaths) {
		this.deaths = deaths;
		return this;
	}

	public PlayerBuilder setWins(int wins) {
		this.wins = wins;
		return this;
	}

	public PlayerBuilder setLosses(int losses) {
		this.losses = losses;
		return this;
	}

	public PlayerBuilder setLogins(int logins) {
		this.logins = logins;
		return this;
	}

	public PlayerBuilder setQuests(int quests) {
		this.quests = quests;
		return this;
	}

	@Override
	public Player build() {
		return new Player(playerID, name, time, level, kills, deaths, wins, losses, logins, quests);
	}
}
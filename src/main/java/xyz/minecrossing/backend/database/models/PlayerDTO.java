package xyz.minecrossing.backend.database.models;

import xyz.minecrossing.backend.database.interfaces.ColName;
import xyz.minecrossing.backend.database.interfaces.IDatabaseModel;

public class PlayerDTO implements IDatabaseModel<String> {
	@ColName(col = PLAYER_ID_COL)
	private String playerID;
	@ColName(col = NAME_COL)
	private String name;
	@ColName(col = TIME_COL)
	private double time;
	@ColName(col = LEVEL_COL)
	private int level;
	@ColName(col = KILLS_COL)
	private int kills;
	@ColName(col = DEATHS_COL)
	private int deaths;
	@ColName(col = WINS_COL)
	private int wins;
	@ColName(col = LOSSES_COL)
	private int losses;
	@ColName(col = LOGINS_COL)
	private int logins;
	@ColName(col = QUESTS_COL)
	private int quests;

	public final static String PLAYER_ID_COL = "uuid";
	public final static String NAME_COL = "name";
	public final static String TIME_COL = "time";
	public final static String LEVEL_COL = "level";
	public final static String KILLS_COL = "kills";
	public final static String DEATHS_COL = "deaths";
	public final static String WINS_COL = "wins";
	public final static String LOSSES_COL = "losses";
	public final static String LOGINS_COL = "logins";
	public final static String QUESTS_COL = "quests";

	public PlayerDTO() {
	}

	public PlayerDTO(String playerID, String name, double time, int level, int kills, int deaths, int wins, int losses, int logins, int quests) {
		this.playerID = playerID;
		this.name = name;
		this.time = time;
		this.level = level;
		this.kills = kills;
		this.deaths = deaths;
		this.wins = wins;
		this.losses = losses;
		this.logins = logins;
		this.quests = quests;
	}

	public String getPlayerID() {
		return playerID;
	}

	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getLogins() {
		return logins;
	}

	public void setLogins(int logins) {
		this.logins = logins;
	}

	public int getQuests() {
		return quests;
	}

	public void setQuests(int quests) {
		this.quests = quests;
	}

	@Override
	public String getKey() {
		return playerID;
	}
}

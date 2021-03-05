package xyz.minecrossing.backend.database.interfaces;

import xyz.minecrossing.backend.database.models.Player;

import java.util.List;

public interface IPlayerResource extends ICRUDResource<Player, String> {
	Player find(String id);
	List<Player> findAll();
}

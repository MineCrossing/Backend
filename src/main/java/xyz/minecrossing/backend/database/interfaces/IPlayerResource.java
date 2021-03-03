package xyz.minecrossing.backend.database.interfaces;

import xyz.minecrossing.backend.database.models.PlayerDTO;

import java.util.List;

public interface IPlayerResource extends ICRUDResource<PlayerDTO, String> {
	PlayerDTO find(String id);
	List<PlayerDTO> findAll();
}

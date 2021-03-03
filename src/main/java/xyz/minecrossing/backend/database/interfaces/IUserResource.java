package xyz.minecrossing.backend.database.interfaces;

import xyz.minecrossing.backend.database.models.UserDTO;

public interface IUserResource extends ICRUDResource<UserDTO, Integer>{
	UserDTO find(Integer id);
}

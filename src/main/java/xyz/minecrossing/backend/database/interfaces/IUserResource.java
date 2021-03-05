package xyz.minecrossing.backend.database.interfaces;

import xyz.minecrossing.backend.database.models.User;

public interface IUserResource extends ICRUDResource<User, Integer>{
	User find(Integer id);
}

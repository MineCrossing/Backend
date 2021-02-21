package xyz.minecrossing.backend.database.interfaces;

import xyz.minecrossing.coreutilities.dbmodels.User;

import java.util.List;

public interface IUserResource extends ICRUDResource<User, String> {
	List<User> getAll();
}

package xyz.minecrossing.backend.database.interfaces;

import xyz.minecrossing.backend.database.models.Role;

public interface IRoleResource extends ICRUDResource<Role, Integer>{
	Role find(Integer id);
}

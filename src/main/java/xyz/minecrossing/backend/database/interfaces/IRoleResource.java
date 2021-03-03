package xyz.minecrossing.backend.database.interfaces;

import xyz.minecrossing.backend.database.models.RoleDTO;

public interface IRoleResource extends ICRUDResource<RoleDTO, Integer>{
	RoleDTO find(Integer id);
}

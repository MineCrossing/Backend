package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.builders.DTOBuilder;
import xyz.minecrossing.backend.database.builders.RoleDTOBuilder;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IRoleResource;
import xyz.minecrossing.backend.database.models.RoleDTO;


public class RoleResource extends MineCrossingStoreResource<RoleDTO, Integer> implements IRoleResource {

	public RoleResource() {
	}

	@Override
	protected QueryBuilder queryBuilder() {
		return new QueryBuilder("roles");
	}

	@Override
	protected DTOBuilder<RoleDTO> modelBuilder() {
		return new RoleDTOBuilder();
	}

	@Override
	public RoleDTO find(Integer id) {
		return find(RoleDTO.ROLE_ID_COL, id);
	}
}

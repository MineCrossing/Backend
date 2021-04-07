package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.builders.ModelBuilder;
import xyz.minecrossing.backend.database.builders.RoleBuilder;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IRoleResource;
import xyz.minecrossing.backend.database.models.Role;


public class RoleResource extends MineCrossingStoreResource<Role, Integer> implements IRoleResource {

	public RoleResource() {
	}

	@Override
	protected QueryBuilder queryBuilder() {
		return new QueryBuilder("roles");
	}

	@Override
	protected ModelBuilder<Role> modelBuilder() {
		return new RoleBuilder();
	}

	@Override
	public Role find(Integer id) {
		return find(Role.ROLE_ID_COL, id);
	}
}

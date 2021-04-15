package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.builders.ModelBuilder;
import xyz.minecrossing.backend.database.builders.RoleBuilder;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IRoleResource;
import xyz.minecrossing.backend.database.models.Role;

/**
 * An implementation of IRoleResource
 *
 * @author Matthew Dodds W18020972
 */
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

	/**
	 * Find an object by ID
	 *
	 * @param id The ID to search by
	 * @return An object if a match is found, null otherwise
	 */
	@Override
	public Role find(Integer id) {
		return find(Role.ROLE_ID_COL, id);
	}
}

package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.builders.DTOBuilder;
import xyz.minecrossing.backend.database.builders.UserDTOBuilder;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IUserResource;
import xyz.minecrossing.backend.database.models.UserDTO;


public class UserResource extends MineCrossingStoreResource<UserDTO, Integer> implements IUserResource {

	public UserResource() {
	}

	protected QueryBuilder queryBuilder() {
		return new QueryBuilder("users");
	}

	@Override
	protected DTOBuilder<UserDTO> modelBuilder() {
		return new UserDTOBuilder();
	}

	@Override
	public UserDTO find(Integer id) {
		return find(UserDTO.USER_ID_COL, id);
	}
}

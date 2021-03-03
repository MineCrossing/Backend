package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.builders.AccessTokenDTOBuilder;
import xyz.minecrossing.backend.database.builders.DTOBuilder;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IAccessTokenResource;
import xyz.minecrossing.backend.database.models.AccessTokenDTO;

public class AccessTokenResource extends MineCrossingStoreResource<AccessTokenDTO, String> implements IAccessTokenResource {
	@Override
	protected QueryBuilder queryBuilder() {
		return new QueryBuilder("oauth_access_tokens");
	}

	@Override
	protected DTOBuilder<AccessTokenDTO> modelBuilder() {
		return new AccessTokenDTOBuilder();
	}

	@Override
	public AccessTokenDTO find(String id) {
		return find(AccessTokenDTO.ACCESS_TOKEN_ID_COL, id);
	}
}

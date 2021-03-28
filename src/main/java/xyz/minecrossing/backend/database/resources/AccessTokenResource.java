package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.builders.AccessTokenBuilder;
import xyz.minecrossing.backend.database.builders.ModelBuilder;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IAccessTokenResource;
import xyz.minecrossing.backend.database.models.AccessToken;

public class AccessTokenResource extends MineCrossingStoreResource<AccessToken, String> implements IAccessTokenResource {
	@Override
	protected QueryBuilder queryBuilder() {
		return new QueryBuilder("oauth_access_tokens");
	}

	@Override
	protected ModelBuilder<AccessToken> modelBuilder() {
		return new AccessTokenBuilder();
	}

	@Override
	public AccessToken find(String id) {
		return find(AccessToken.ACCESS_TOKEN_ID_COL, id);
	}

	@Override
	public boolean revoke(AccessToken token) {
		if (token == null || token.isRevoked())
			return true;

		token.setRevoked(true);

		return update(token);
	}
}

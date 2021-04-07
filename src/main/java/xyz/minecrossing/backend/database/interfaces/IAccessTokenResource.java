package xyz.minecrossing.backend.database.interfaces;

import xyz.minecrossing.backend.database.models.AccessToken;

public interface IAccessTokenResource extends ICRUDResource<AccessToken, String>{
	AccessToken find(String id);
	boolean revoke(AccessToken id);
	boolean validate(String tokenID, int userID);
}

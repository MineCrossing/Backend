package xyz.minecrossing.backend.database.interfaces;

import xyz.minecrossing.backend.database.models.AccessTokenDTO;

public interface IAccessTokenResource extends ICRUDResource<AccessTokenDTO, String>{
	AccessTokenDTO find(String id);
}

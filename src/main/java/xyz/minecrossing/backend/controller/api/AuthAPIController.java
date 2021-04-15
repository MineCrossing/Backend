package xyz.minecrossing.backend.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import xyz.minecrossing.backend.controller.api.requests.AuthRequest;
import xyz.minecrossing.backend.controller.api.responses.AuthResponse;
import xyz.minecrossing.backend.database.MineCrossingDB;
import xyz.minecrossing.backend.helpers.StringUtils;

/**
 * An implementation of AuthApi
 *
 * @author Matthew Dodds W18020972
 */
@RestController
public class AuthAPIController implements AuthAPI {
	private final MineCrossingDB db;

	public AuthAPIController() {
		db = MineCrossingDB.getInstance();
	}

	/**
	 * A method to validate an authentication request
	 *
	 * @param body The authentication credentials
	 * @return A response indicating whether the login was successful and whether or not the user is an administrator
	 */
	@Override
	public ResponseEntity<AuthResponse> checkAuth(AuthRequest body) {
		if (body == null || body.getUserId() == 0 || StringUtils.isNullOrEmpty(body.getToken()))
			return ResponseEntity.badRequest().body(new AuthResponse());

		var user = db.Users.find(body.getUserId());
		if (user == null)
			return ResponseEntity.ok().body(new AuthResponse());

		if (!db.AccessTokens.validate(body.getToken(), user.getUserID()))
			return ResponseEntity.ok().body(new AuthResponse());

		var role = db.Roles.find(user.getRoleID());

		return ResponseEntity.ok().body(new AuthResponse(true, role.getRoleName().equalsIgnoreCase("admin"), user.getUserID()));
	}

	/**
	 * A method to handle logging a user out
	 *
	 * @param body the authentication credentials
	 * @return True if logout was successful, false if an error occurs
	 */
	@Override
	public ResponseEntity<Boolean> logout(AuthRequest body) {
		if (body == null || StringUtils.isNullOrEmpty(body.getToken()))
			return ResponseEntity.ok(true);

		var token = db.AccessTokens.find(body.getToken());

		if (token == null)
			return ResponseEntity.ok(true);

		return ResponseEntity.ok(db.AccessTokens.revoke(token));
	}
}

package xyz.minecrossing.backend.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import xyz.minecrossing.backend.controller.api.requests.AuthRequest;
import xyz.minecrossing.backend.controller.api.responses.AuthResponse;
import xyz.minecrossing.backend.database.MineCrossingDB;
import xyz.minecrossing.backend.helpers.StringUtils;

@RestController
public class AuthAPIController implements AuthAPI {
	private final MineCrossingDB db;

	public AuthAPIController() {
		db = MineCrossingDB.getInstance();
	}

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
}

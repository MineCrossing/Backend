package xyz.minecrossing.backend.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import xyz.minecrossing.backend.controller.api.requests.AuthRequest;
import xyz.minecrossing.backend.controller.api.responses.AuthResponse;
import xyz.minecrossing.backend.database.MineCrossingDB;

@RestController
public class AuthAPIController implements AuthAPI {
	private MineCrossingDB db;

	public AuthAPIController() {
		db = MineCrossingDB.getInstance();
	}

	@Override
	public ResponseEntity<AuthResponse> checkAuth(AuthRequest body) {
		var token = db.AccessTokens.find(body.getJTI());

		if (token == null || token.isRevoked() || token.getUserID() != body.getUserID())
			return ResponseEntity.ok().body(new AuthResponse());

		/*if (token.getExpiresAt().isAfter(LocalDateTime.now())) {
			db.AccessTokens.revoke(token);
			return ResponseEntity.ok().body(new AuthResponse());
		}*/

		var user = db.Users.find(body.getUserID());

		if (user == null)
			return ResponseEntity.ok().body(new AuthResponse());

		var role = db.Roles.find(user.getRoleID());

		return ResponseEntity.ok().body(new AuthResponse(true, role.getRoleName().equalsIgnoreCase("admin")));
	}
}

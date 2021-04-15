package xyz.minecrossing.backend.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import xyz.minecrossing.backend.controller.api.requests.AuthRequest;
import xyz.minecrossing.backend.controller.api.responses.AuthResponse;

/**
 * An interface outlining the functionality of the authentication endpoint
 *
 * @author Matthew Dodds W18020972
 */
public interface AuthAPI {
	/**
	 * A method to validate an authentication request
	 *
	 * @param body The authentication credentials
	 * @return A response indicating whether the login was successful and whether or not the user is an administrator
	 */
	@PostMapping(
			value = "/checkAuth",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<AuthResponse> checkAuth(@RequestBody AuthRequest body);

	/**
	 * A method to handle logging a user out
	 *
	 * @param body the authentication credentials
	 * @return True if logout was successful, false if an error occurs
	 */
	@PostMapping(
			value = "/logout",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<Boolean> logout(@RequestBody AuthRequest body);
}

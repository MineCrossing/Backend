package xyz.minecrossing.backend.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import xyz.minecrossing.backend.controller.api.requests.AuthRequest;
import xyz.minecrossing.backend.controller.api.responses.AuthResponse;

public interface AuthAPI {
	@PostMapping(
			value = "/checkAuth",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<AuthResponse> checkAuth(@ModelAttribute AuthRequest body);
}

package xyz.minecrossing.backend.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * An interface outlining the functionality of the Players endpoint
 *
 * @author Matthew Dodds W18020972
 */
public interface PlayersAPI {

    /**
     * Returns a list of all players
     *
     * @return A list of all players
     */
    @GetMapping("/players")
    ResponseEntity<Object> players();

}

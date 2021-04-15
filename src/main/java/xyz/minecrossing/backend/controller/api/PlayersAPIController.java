package xyz.minecrossing.backend.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import xyz.minecrossing.backend.database.MineCrossingDB;

/**
 * An implementation of PlayersAPI
 *
 * @author Matthew Dodds W18020972
 */
@RestController
public class PlayersAPIController implements PlayersAPI {

    /**
     * Returns a list of all players
     *
     * @return A list of all players
     */
    @Override
    public ResponseEntity<Object> players() {
        var db = MineCrossingDB.getInstance();
        return new ResponseEntity<>(db.Players.findAll(), HttpStatus.OK);
    }

}

package xyz.minecrossing.backend.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import xyz.minecrossing.backend.database.MineCrossingDB;

@RestController
public class PlayersAPIController implements PlayersAPI {

    @Override
    public ResponseEntity<Object> players() {
        var db = MineCrossingDB.getInstance();
        return new ResponseEntity<>(db.Players.findAll(), HttpStatus.OK);
    }

}

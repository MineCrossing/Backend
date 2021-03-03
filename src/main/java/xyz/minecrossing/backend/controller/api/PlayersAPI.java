package xyz.minecrossing.backend.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface PlayersAPI {

    @GetMapping("/players")
    ResponseEntity<Object> players();

}

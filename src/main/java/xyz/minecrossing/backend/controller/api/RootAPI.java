package xyz.minecrossing.backend.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * An interface to act as the default root location of the API
 *
 * @author Thomas Griffiths W18013094
 */
public interface RootAPI {

    @GetMapping("/")
    ResponseEntity<Object> base();

}

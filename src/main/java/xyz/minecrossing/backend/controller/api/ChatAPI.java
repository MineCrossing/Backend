package xyz.minecrossing.backend.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface ChatAPI {

    @GetMapping("/")
    ResponseEntity<Object> base();

    @GetMapping("/chat")
    ResponseEntity<Object> chat();

}

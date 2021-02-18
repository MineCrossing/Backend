package xyz.minecrossing.backend.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public interface TestAPI {

    @GetMapping("/")
    ResponseEntity<String> api();

    @GetMapping("/test")
    ResponseEntity<String> test();

}

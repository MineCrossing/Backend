package xyz.minecrossing.backend.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public interface TestAPI {

    @GetMapping("/")
    ResponseEntity<Object> api();

    @GetMapping("/test")
    ResponseEntity<Object> test();

}

package xyz.minecrossing.backend.controller.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface TestAPI {

    @GetMapping("/")
    ResponseEntity<Object> api();

    @GetMapping("/test")
    ResponseEntity<Object> test();

    @RequestMapping(value = "/objtest", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TestAPIController.TestObject> objtest();
}

package xyz.minecrossing.backend.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class TestAPIController implements TestAPI {

    @Override
    public ResponseEntity<String> api() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Test message!", HttpStatus.OK);
    }
}

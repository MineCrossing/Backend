package xyz.minecrossing.backend.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import xyz.minecrossing.backend.MineCrossing;

import java.util.HashMap;

@Controller
public class TestAPIController implements TestAPI {

    @Override
    public ResponseEntity<Object> api() {
        HashMap<String, String> value = new HashMap<>();
        value.put("msg", "Hello World!");
        return new ResponseEntity<>(value, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> test() {
        HashMap<String, String> value = new HashMap<>();
        value.put("msg", "Test message!");
        return new ResponseEntity<>(value, HttpStatus.OK);
    }
}

package xyz.minecrossing.backend.controller.api;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class RootAPIController implements RootAPI, ErrorController {

    private static final String ERROR_PATH = "/error";

    @Override
    public ResponseEntity<Object> base() {
        HashMap<String, String> base = new HashMap<>();
        base.put("message", "Hello World!");
        return new ResponseEntity<>(base, HttpStatus.OK);
    }

    @GetMapping(ERROR_PATH)
    public ResponseEntity<Object> error() {
        HashMap<String, String> base = new HashMap<>();
        base.put("message", "Invalid API endpoint provided!");
        return new ResponseEntity<>(base, HttpStatus.OK);
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}

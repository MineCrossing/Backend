package xyz.minecrossing.backend.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import xyz.minecrossing.backend.minecraft.ChatManager;

import java.util.HashMap;

@RestController
public class ChatAPIController implements ChatAPI {

    //@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

    @Override
    public ResponseEntity<Object> base() {
        HashMap<String, String> base = new HashMap<>();
        base.put("message", "Hello World!");
        return new ResponseEntity<>(base, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> chat() {
        return new ResponseEntity<>(ChatManager.getMessages(), HttpStatus.OK);
    }
}

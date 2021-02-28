package xyz.minecrossing.backend.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;
import xyz.minecrossing.backend.minecraft.ChatManager;
import xyz.minecrossing.coreutilities.Logger;

import java.util.HashMap;
import java.util.Map;

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

    @Override
    public ResponseEntity<Object> send(Map<String, Object> body) {
        for (Map.Entry<String, Object> entry : body.entrySet()) {
            String msg = entry.getValue().toString();
            Logger.info("Received message: " + msg);
            ChatManager.addMessage("[WEB] Anonymous: " + msg);
        }
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}

package xyz.minecrossing.backend.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * An interface outlining the functionality of the chat endpoints
 *
 * @author Thomas Griffiths W18013094
 */
public interface ChatAPI {

    @GetMapping("/chat")
    ResponseEntity<Object> chat();

    @RequestMapping(
            value = "/chat/send",
            produces = "application/json",
            method = RequestMethod.POST
    )
    @ResponseBody
    ResponseEntity<Object> send(@RequestBody Map<String, Object> body);

}

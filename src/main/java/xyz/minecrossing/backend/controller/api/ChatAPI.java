package xyz.minecrossing.backend.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface ChatAPI {

    @GetMapping("/")
    ResponseEntity<Object> base();

    @GetMapping("/chat")
    ResponseEntity<Object> chat();

    //@PutMapping("/chat/send/{msg}")
    @RequestMapping(
            value = "/chat/send",
            produces = "application/json",
            method = RequestMethod.POST
    )
    @ResponseBody
    ResponseEntity<Object> send(@RequestBody Map<String, Object> body);

}

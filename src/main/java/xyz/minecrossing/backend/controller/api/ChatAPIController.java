package xyz.minecrossing.backend.controller.api;

import chat.tidy.TidyChat;
import chat.tidy.event.PacketOutboundEvent;
import chat.tidy.message.ChatMessage;
import chat.tidy.socket.packet.CheckMessageOutboundPacket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import xyz.minecrossing.backend.helpers.ChatFilter;
import xyz.minecrossing.backend.minecraft.ChatManager;
import xyz.minecrossing.coreutilities.Logger;

import java.util.Map;
import java.util.UUID;

@RestController
public class ChatAPIController implements ChatAPI {

    @Override
    public ResponseEntity<Object> chat() {
        return new ResponseEntity<>(ChatManager.getMessages(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> send(Map<String, Object> body) {
        for (Map.Entry<String, Object> entry : body.entrySet()) {
            String msg = entry.getValue().toString();

            UUID uuid = UUID.randomUUID();
            UUID chatUUID = UUID.randomUUID();
            ChatMessage chatMessage = new ChatMessage(chatUUID, msg);
            TidyChat.getInstance().getEventManager().callEvent(new PacketOutboundEvent(new CheckMessageOutboundPacket(uuid, chatMessage)));
        }
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

}

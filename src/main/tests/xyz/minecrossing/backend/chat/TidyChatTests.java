package xyz.minecrossing.backend.chat;

import chat.tidy.TidyChat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TidyChatTests {

    @Test
    void initialise() {
        assertNotNull(TidyChat.getInstance());
    }

    @Test
    void bearerExists() {
        assertNotEquals(TidyChat.getInstance().getBearer(), "");
    }

}

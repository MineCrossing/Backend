package xyz.minecrossing.backend.helpers;

import chat.tidy.TidyChat;
import chat.tidy.message.ChatMessage;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class ChatFilterTests {

    @Test
    void connectionIsNotNull() {
        assertNotNull(ChatFilter.connect(TidyChat.getInstance()));
    }

    @Test
    void messageIsFiltered() {
        ChatMessage message = ChatFilter.filterMessage("default message");

        assertNotNull(message);
        assertNotNull(message.getMessage());
        assertNotEquals(message.getMessage(), "");
    }

    @Test
    void responseIsEmpty() throws IOException {
        InputStream is = InputStream.nullInputStream();
        String response = ChatFilter.readResponse(is);

        assertNotNull(response);
        assertEquals(response, "");

        assertTrue(StringUtils.isNullOrEmpty(response));
    }

}

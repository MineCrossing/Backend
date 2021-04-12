package xyz.minecrossing.backend.chat;

import chat.tidy.TidyChat;
import org.junit.jupiter.api.Test;
import xyz.minecrossing.backend.helpers.ChatFilter;
import xyz.minecrossing.backend.helpers.StringUtils;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class FilterTests {

    @Test
    void connectionIsNotNull() {
        assertNotNull(ChatFilter.connect(TidyChat.getInstance()));
    }

    @Test
    void responseIsEmpty() throws IOException {
        InputStream is = InputStream.nullInputStream();
        assertTrue(StringUtils.isNullOrEmpty(ChatFilter.readResponse(is)));
    }

}

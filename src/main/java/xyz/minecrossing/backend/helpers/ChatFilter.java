package xyz.minecrossing.backend.helpers;

import chat.tidy.TidyChat;
import chat.tidy.event.PacketOutboundEvent;
import chat.tidy.message.ChatMessage;
import chat.tidy.socket.WebSocketClient;
import chat.tidy.socket.packet.CheckMessageOutboundPacket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Utility class containing tidychat helper methods
 *
 * @author Thomas Griffiths W18013094
 */
public class ChatFilter {

    /**
     * Establish a connection with the tidychat service and return
     * the connection socket.
     *
     * @param tidyChat An instance of tidychat-java
     * @return The tidychat connection socket for this application
     */
    public static CompletableFuture<WebSocketClient> connect(TidyChat tidyChat) {
        CompletableFuture<WebSocketClient> future = new CompletableFuture<>();

        future.completeAsync(() -> {
            tidyChat.getSocketClient().connect();
            return tidyChat.getSocketClient();
        });

        return future;
    }

    /**
     * Create a ChatMessage and send it to tidychat to be filtered
     *
     * @param message The message to filter
     */
    public static ChatMessage filterMessage(String message) {
        UUID uuid = UUID.randomUUID();
        UUID chatUUID = UUID.randomUUID();
        ChatMessage chatMessage = new ChatMessage(chatUUID, message);
        TidyChat.getInstance().getEventManager().callEvent(new PacketOutboundEvent(new CheckMessageOutboundPacket(uuid, chatMessage)));

        return chatMessage;
    }

    /**
     * Read the response of an API call and return its result
     *
     * @param input The input stream of the API call connection
     * @return The response result as a String
     * @throws IOException when the InputStream fails
     */
    public static String readResponse(InputStream input) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(input));

        String inputLine;
        StringBuilder sb = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            sb.append(inputLine);
        }
        in.close();

        return sb.toString();
    }

}

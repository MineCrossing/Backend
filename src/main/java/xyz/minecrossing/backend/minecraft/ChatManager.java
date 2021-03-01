package xyz.minecrossing.backend.minecraft;

import xyz.minecrossing.redisapi.redis.RedisChannelListener;

import java.util.ArrayList;
import java.util.List;

public class ChatManager implements RedisChannelListener {

    private static final List<String> MESSAGES = new ArrayList<>();

    /**
     * When a message is received from Redis
     *
     * @param message The message received from Redis
     */
    @Override
    public void messageReceived(String message) {
        addMessage(message);
    }

    /**
     * Add a new chat message to the end of the list whilst
     * removing the oldest message from the list.
     * <p>
     * Uses {@link ArrayList#remove(int index)} to shuffle
     * all remaining contents to the left when full.
     *
     * @param message The message to add
     */
    public static void addMessage(String message) {
        if (MESSAGES.size() > 100) {
            MESSAGES.remove(0);
        }
        MESSAGES.add(message);
    }

    /**
     * Get a list of all recent chat messages
     *
     * @return A list of all recent chat messages
     */
    public static List<String> getMessages() {
        return MESSAGES;
    }
}

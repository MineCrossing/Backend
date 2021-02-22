package xyz.minecrossing.backend.minecraft;

import xyz.minecrossing.redisapi.redis.RedisChannelListener;

import java.util.ArrayList;
import java.util.List;

public class ChatManager implements RedisChannelListener {

    private static final List<String> messages = new ArrayList<>();

    @Override
    public void messageReceived(String message) {
        addMessage(message);
    }

    public static void addMessage(String message) {
        messages.add(message);
    }

    public static List<String> getMessages() {
        return messages;
    }
}

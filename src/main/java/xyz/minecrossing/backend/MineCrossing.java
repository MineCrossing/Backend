package xyz.minecrossing.backend;

import chat.tidy.TidyChat;
import com.google.gson.Gson;

public class MineCrossing {

    private static final Gson GSON = new Gson();

    private static MineCrossing instance;

    private final TidyChat tidyChat;

    public MineCrossing() {
        this.tidyChat = TidyChat.getInstance();
    }

    public static MineCrossing getInstance() {
        if (instance == null) instance = new MineCrossing();
        return instance;
    }

    public TidyChat getTidyChat() {
        return tidyChat;
    }

    public Gson getGSON() {
        return GSON;
    }
}

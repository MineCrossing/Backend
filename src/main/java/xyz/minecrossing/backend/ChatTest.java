package xyz.minecrossing.backend;

import chat.tidy.TidyChat;
import chat.tidy.listener.Listener;
import xyz.minecrossing.backend.controller.api.chat.ConnectionListener;
import xyz.minecrossing.backend.controller.api.chat.PacketReceivedListener;
import xyz.minecrossing.backend.controller.api.chat.PacketSentListener;
import xyz.minecrossing.backend.helpers.ChatFilter;
import xyz.minecrossing.coreutilities.Logger;

public class ChatTest {

    public static void main(String[] args) {
        /*TidyChat tidyChat = TidyChat.getInstance();

        tidyChat.setLoggerConsumer(s -> Logger.custom("tidychat", s));

        ChatFilter.connect(tidyChat).whenComplete((socket, err) -> {
            if (err != null) {
                Logger.error("Something went wrong connecting to tidychat!");
                return;
            } else {
                Logger.info("Backend attached to tidychat!");
            }

            registerListeners(
                    new ConnectionListener(),
                    new PacketReceivedListener(),
                    new PacketSentListener()
            );
        });*/
    }

    /**
     * Register a list of listeners for chat filter
     *
     * @param listeners The list of listeners
     */
    private static void registerListeners(Listener... listeners) {
        for (Listener listener : listeners) {
            TidyChat.getInstance().getEventManager().registerListener(listener);
        }
    }

}

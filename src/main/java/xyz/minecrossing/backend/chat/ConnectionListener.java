package xyz.minecrossing.backend.chat;

import chat.tidy.event.ConnectionStateChangedEvent;
import chat.tidy.event.EventHandler;
import chat.tidy.listener.Listener;

public class ConnectionListener implements Listener {

    @EventHandler
    public void onConnectionChange(ConnectionStateChangedEvent event) {
        event.getTidyChat().getLoggerConsumer().accept("Connection: " + event.getConnectionState().name());
    }

}

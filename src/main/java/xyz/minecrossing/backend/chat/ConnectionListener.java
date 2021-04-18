package xyz.minecrossing.backend.chat;

import chat.tidy.event.ConnectionStateChangedEvent;
import chat.tidy.event.EventHandler;
import chat.tidy.listener.Listener;

/**
 * A tidychat event to listen to the connection to the service and log it
 *
 * @author Thomas Griffiths W18013094
 */
public class ConnectionListener implements Listener {

    @EventHandler
    public void onConnectionChange(ConnectionStateChangedEvent event) {
        event.getTidyChat().getLoggerConsumer().accept("Connection: " + event.getConnectionState().name());
    }

}

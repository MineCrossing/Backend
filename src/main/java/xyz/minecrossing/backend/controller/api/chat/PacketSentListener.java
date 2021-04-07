package xyz.minecrossing.backend.controller.api.chat;

import chat.tidy.event.EventHandler;
import chat.tidy.event.PacketOutboundEvent;
import chat.tidy.listener.Listener;
import chat.tidy.socket.packet.CheckMessageOutboundPacket;
import chat.tidy.socket.packet.OutboundPacket;
import xyz.minecrossing.coreutilities.Logger;

/**
 * Event for when a packet is sent out to tidychat to process a message
 */
public class PacketSentListener implements Listener {

    @EventHandler
    public void onPacketOutbound(PacketOutboundEvent event) {
        OutboundPacket packet = event.getPacket();
        if (packet instanceof CheckMessageOutboundPacket) {
            CheckMessageOutboundPacket out = (CheckMessageOutboundPacket) packet;
            event.getTidyChat().getLoggerConsumer().accept(
                    "Sending tidychat message: " + out.getChatMessage().getMessage()
            );
        }
    }

}

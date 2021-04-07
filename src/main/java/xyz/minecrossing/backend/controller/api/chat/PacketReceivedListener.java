package xyz.minecrossing.backend.controller.api.chat;

import chat.tidy.event.EventHandler;
import chat.tidy.event.PacketInboundEvent;
import chat.tidy.listener.Listener;
import chat.tidy.socket.packet.CheckMessageInboundPacket;
import chat.tidy.socket.packet.InboundPacket;
import xyz.minecrossing.backend.minecraft.ChatManager;

/**
 * Event for when a packet is received from tidychat with a cleaned message
 */
public class PacketReceivedListener implements Listener {

    @EventHandler
    public void onPacketInbound(PacketInboundEvent event) {
        InboundPacket packet = event.getPacket();
        if (packet instanceof CheckMessageInboundPacket) {
            CheckMessageInboundPacket in = (CheckMessageInboundPacket) packet;
            String message = in.getChatMessage().getMessage();

            event.getTidyChat().getLoggerConsumer().accept(
                    "Received cleaned message: " + message
            );

            ChatManager.addMessage("[WEB] Anonymous: " + message);
        }
    }

}

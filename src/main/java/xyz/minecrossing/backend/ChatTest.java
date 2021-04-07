package xyz.minecrossing.backend;

import chat.tidy.TidyChat;
import com.mysql.jdbc.log.Log;
import io.grpc.netty.shaded.io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import xyz.minecrossing.backend.controller.api.chat.TidyChatConnection;
import xyz.minecrossing.backend.helpers.ChatFilter;
import xyz.minecrossing.coreutilities.Logger;

public class ChatTest {

    public static void main(String[] args) {
        TidyChat tidyChat = TidyChat.getInstance();

        tidyChat.setLoggerConsumer(s -> Logger.custom("tidychat", s));

        ChatFilter.connect(tidyChat).whenComplete((socket, err) -> {
            if (err != null) {
                Logger.error("Something went wrong connecting to tidychat!");
                return;
            } else {
                Logger.info("Backend attached to tidychat!");
            }

            tidyChat.getEventManager().registerListener(new TidyChatConnection());
            tidyChat.getEventManager().registerListener(new ChatFilter());

            socket.send(new TextWebSocketFrame("Hello Fuck"));

            socket.close();
        });

        /*try {
            System.out.println("hello 1");
            URL url = new URL("https://www.purgomalum.com/service/json?text=fuck");
            System.out.println("hello 2");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            System.out.println("hello 3");
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            System.out.println("hello 4");

            Logger.info("Responding: " + con.getResponseCode());

            if (con.getResponseCode() == 200) {
                System.out.println("hello 2");
                System.out.println(ChatFilter.readResponse(con.getInputStream()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*ChatFilter.filter("fuck").whenComplete((msg, error) -> {
            if (error != null) {
                Logger.error("Error when filtering chat message:");
                error.printStackTrace();
                return;
            }

            Logger.info("Received message: " + msg);
        });*/
    }

}

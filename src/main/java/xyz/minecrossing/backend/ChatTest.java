package xyz.minecrossing.backend;

import xyz.minecrossing.backend.helpers.ChatFilter;
import xyz.minecrossing.coreutilities.Logger;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChatTest {

    public static void main(String[] args) {
        try {
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
        }

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

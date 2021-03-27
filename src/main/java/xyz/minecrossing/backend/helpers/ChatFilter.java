package xyz.minecrossing.backend.helpers;

import xyz.minecrossing.coreutilities.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.concurrent.CompletableFuture;

public class ChatFilter {

    //public static final String URL = "http://api.minecrossing.xyz";
    public static final String URL = "https://www.purgomalum.com/";
    public static final String RELATIVE = "service/json?text=";

    public static CompletableFuture<String> filter(String msg) {
        System.out.println("hurray");
        CompletableFuture<String> future = new CompletableFuture<>();
        future.thenApply(s -> {
            try {
                System.out.println("hello 1");
                URL url = new URL(new URL(URL), RELATIVE + msg);
                System.out.println("hello 2");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                System.out.println("hello 3");
                con.setRequestMethod("GET");
                con.setRequestProperty("Content-Type", "application/json");
                System.out.println("hello 4");

                Logger.info("Responding: " + con.getResponseCode());

                if (con.getResponseCode() == 200) {
                    System.out.println("hello 2");
                    return readResponse(con.getInputStream());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return msg;
        });

        return future;
    }

    /**
     * Read the response of an API call and return its result
     *
     * @param input The input stream of the API call connection
     * @return The response result as a String
     * @throws IOException when the InputStream fails
     */
    public static String readResponse(InputStream input) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(input));

        String inputLine;
        StringBuilder sb = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            sb.append(inputLine);
        }
        in.close();

        return sb.toString();
    }

}

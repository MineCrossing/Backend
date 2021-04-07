package xyz.minecrossing.backend;

import chat.tidy.TidyChat;
import chat.tidy.listener.Listener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xyz.minecrossing.backend.chat.ConnectionListener;
import xyz.minecrossing.backend.chat.PacketReceivedListener;
import xyz.minecrossing.backend.chat.PacketSentListener;
import xyz.minecrossing.backend.helpers.ChatFilter;
import xyz.minecrossing.backend.minecraft.ChatManager;
import xyz.minecrossing.coreutilities.Logger;
import xyz.minecrossing.redisapi.RedisAPI;
import xyz.minecrossing.redisapi.redis.RedisConnector;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        Logger.info("Hello World!");

        SpringApplication.run(BackendApplication.class, args);

        // Connect to redis and establish connection with game chat
        RedisAPI redisAPI = RedisAPI.getRedisAPI();
        redisAPI.initialize();

        RedisConnector redisConnector = redisAPI.getRedisConnector();
        redisConnector.listenForChannel("gameChat", new ChatManager());

        // Setup tidychat
        TidyChat chat = TidyChat.getInstance();
        chat.setLoggerConsumer(s -> Logger.custom("tidychat", s)); // let tidychat use our logger

        // Connect to tidychat socket and register listeners
        ChatFilter.connect(chat).whenComplete((socket, err) -> {
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
        });
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

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins(
                        "https://minecrossing.xyz",
                        "http://localhost:8080",
                        "http://localhost:3000"
                );
            }
        };
    }

}

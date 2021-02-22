package xyz.minecrossing.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.minecrossing.backend.minecraft.ChatManager;
import xyz.minecrossing.coreutilities.Logger;
import xyz.minecrossing.redisapi.RedisAPI;
import xyz.minecrossing.redisapi.redis.RedisConnector;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        Logger.info("Hello World!");

        SpringApplication.run(BackendApplication.class, args);

        RedisAPI redisAPI = RedisAPI.getRedisAPI();
        redisAPI.initialize();

        RedisConnector redisConnector = redisAPI.getRedisConnector();
        redisConnector.listenForChannel("gameChat", new ChatManager());
    }

}

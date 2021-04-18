package xyz.minecrossing.backend;

import chat.tidy.TidyChat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import xyz.minecrossing.backend.chat.ConnectionListener;
import xyz.minecrossing.backend.chat.PacketReceivedListener;
import xyz.minecrossing.backend.chat.PacketSentListener;
import xyz.minecrossing.redisapi.RedisAPI;

import static org.junit.jupiter.api.Assertions.*;

public class BackendApplicationTests {

    private static BackendApplication backend;

    @BeforeAll
    static void beforeAll() {
        backend = new BackendApplication();
    }

    @Test
    void mainRan() {
        BackendApplication.main(new String[0]);

        assertNotNull(RedisAPI.getRedisAPI());
        assertNotNull(RedisAPI.getRedisAPI().getRedisConnector());

        assertNotNull(TidyChat.getInstance());
        assertNotEquals(TidyChat.getInstance().getBearer(), "");
    }

    @Test
    void registeredListeners() {
        BackendApplication.registerListeners(
                new ConnectionListener(),
                new PacketReceivedListener(),
                new PacketSentListener()
        );
    }

    @Test
    void corsSetup() {
        assertNotNull(backend.corsConfigurer());
    }

}

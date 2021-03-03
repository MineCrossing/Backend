package xyz.minecrossing.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xyz.minecrossing.coreutilities.Logger;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        Logger.info("Hello World!");

        SpringApplication.run(BackendApplication.class, args);

       /* RedisAPI redisAPI = RedisAPI.getRedisAPI();
        redisAPI.initialize();

        RedisConnector redisConnector = redisAPI.getRedisConnector();
        redisConnector.listenForChannel("gameChat", new ChatManager());*/
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

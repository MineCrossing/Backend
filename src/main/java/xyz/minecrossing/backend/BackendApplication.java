package xyz.minecrossing.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.minecrossing.coreutilities.Logger;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        Logger.info("Hello World!");

        SpringApplication.run(BackendApplication.class, args);
    }

}

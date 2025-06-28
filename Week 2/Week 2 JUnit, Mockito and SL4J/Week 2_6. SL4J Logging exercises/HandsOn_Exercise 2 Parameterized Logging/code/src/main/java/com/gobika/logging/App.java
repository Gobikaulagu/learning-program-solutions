package com.gobika.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        String username = "Gobika";
        LocalDateTime loginTime = LocalDateTime.now();

        logger.info("User {} has logged in at {}", username, loginTime);
        logger.warn("User {} attempted to access restricted section", username);
        logger.error("System error for user {} at {}", username, loginTime);
    }
}

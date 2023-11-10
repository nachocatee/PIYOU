package com.b106_402jeoung.PIYOU.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class FCMInitializer {
    @Value("${fcm.key.path}")
    private String FCM_KEY_PATH;
    Logger logger = LoggerFactory.getLogger(FCMInitializer.class);

    @PostConstruct
    public void initialize() {
        try {
            FirebaseOptions options = FirebaseOptions.builder().setCredentials(
                            GoogleCredentials.fromStream(new ClassPathResource(FCM_KEY_PATH).getInputStream()))
                    .build();

            if (FirebaseApp.getApps()
                    .isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}

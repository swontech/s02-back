package com.swontech.s02.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.InputStream;

@Configuration
public class FirebaseConfigration {

    @Value("classpath:keystore/service-account.json")
    private Resource resource;
    private String filePath;

    @Bean
    @Primary
    public void initFirebase() {
        filePath = "keystore/service-account.json";
        try {
            // Service Account를 이용하여 Fireabse Admin SDK 초기화

            // Local
//            FileInputStream serviceAccount = new FileInputStream(resource.getFile());
            // Server
            InputStream serviceAccount = new ClassPathResource(filePath).getInputStream();

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                    .setDatabaseUrl("https://byapp-35c1e.firebaseio.com")
                    .build();
            if (FirebaseApp.getApps().isEmpty()) {
                System.out.println("Firebase Initialize");
                FirebaseApp.initializeApp(options);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

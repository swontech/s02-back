package com.swontech.s02.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

@Configuration
public class FirebaseConfigration {

    @Value("classpath:keystore/service-account.json")
    private Resource resource;

    @PostConstruct
    public void initFirebase() {
        try {
            // Service Account를 이용하여 Fireabse Admin SDK 초기화
            FileInputStream serviceAccount = new FileInputStream(resource.getFile());
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                    .setDatabaseUrl("https://byapp-35c1e.firebaseio.com")
                    .build();
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

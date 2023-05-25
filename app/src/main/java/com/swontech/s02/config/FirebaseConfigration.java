package com.swontech.s02.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;
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
//            File tempFile = File.createTempFile("service-account", ".json");
//            try {
//                FileUtils.copyInputStreamToFile(inputStream, tempFile);
//            } finally {
//                IOUtils.closeQuietly(inputStream);
//            }

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
//            FirebaseOptions options = new FirebaseOptions.Builder()
//                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                    .setDatabaseUrl("https://byapp-35c1e.firebaseio.com")
//                    .build();
            if (FirebaseApp.getApps().isEmpty()) {
                System.out.println("Firebase Initialize");
                FirebaseApp.initializeApp(options);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

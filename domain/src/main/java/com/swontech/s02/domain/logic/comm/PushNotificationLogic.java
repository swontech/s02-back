package com.swontech.s02.domain.logic.comm;

import com.google.firebase.messaging.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PushNotificationLogic {

    public void sendPushNotification(String userToken, String sendTitle, String sendBody) {
        String msg;
        try {
            sendMessageTo(userToken, sendTitle, sendBody);
            msg = "SUCCESS";
        } catch (IOException | FirebaseMessagingException e) {
            msg = "FAIL";
        }
        System.out.println("RESULT: " + msg);
    }

    public void sendMessageTo(String targetToken, String title, String body) throws IOException, FirebaseMessagingException {
        Message message = Message.builder()
                .setNotification(Notification.builder()
                        .setTitle(title)
                        .setBody(body)
                        .setImage(null)
                        .build())
                .setAndroidConfig(AndroidConfig.builder()
                        .setPriority(AndroidConfig.Priority.HIGH)
                        .setNotification(AndroidNotification.builder()
                                .setChannelId("s02App")
                                .setTitle(title)
                                .setBody(body)
                                .setImage(null)
                                .setSound("default")
                                .build())
                        .build())
                .setApnsConfig(ApnsConfig.builder()
                        .setAps(Aps.builder()
                                .setSound("default")
                                .setContentAvailable(true)
                                .build())
                        .build())
                .setToken(targetToken)
                .build();

        String response = FirebaseMessaging.getInstance().send(message);
        System.out.println("RESULT: " + response);
    }

}

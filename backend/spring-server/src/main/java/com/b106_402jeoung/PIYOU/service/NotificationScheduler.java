//package com.b106_402jeoung.PIYOU.service;
//
//import com.b106_402jeoung.PIYOU.dto.RequestPushMessage;
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import com.google.firebase.messaging.FirebaseMessaging;
//import com.google.firebase.messaging.FirebaseMessagingException;
//import com.google.firebase.messaging.Message;
//import com.google.firebase.messaging.Notification;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.io.IOException;
//import java.util.Collections;
//
//@Slf4j
//@Service
//public class NotificationScheduler {
//    @Value("${fcm.key.scoped}")
//    String fireBaseCreateScoped;
//
//    @Value("${fcm.key.topic}")
//    String topic;
//
//    @Value("${fcm.key.path}")
//    String fireBaseKeyPath;
//    private FirebaseMessaging instance;
//
//    @PostConstruct
//    public void firebaseSetting() throws IOException {
//        GoogleCredentials googleCredentials = GoogleCredentials.fromStream(
//                        new ClassPathResource(fireBaseKeyPath).getInputStream())
//                .createScoped(Collections.singletonList(fireBaseCreateScoped));
//
//        FirebaseOptions secondaryAppConfig = FirebaseOptions.builder()
//                .setCredentials(googleCredentials)
//                .build();
//
//        FirebaseApp app = FirebaseApp.initializeApp(secondaryAppConfig);
//        this.instance = FirebaseMessaging.getInstance(app);
//    }
//
//    @Scheduled(cron = "0 0 09 * * ?")
//    public void pushMorningMealAlarm() throws FirebaseMessagingException {
//        log.info("아침 식사 알림");
//        pushAlarm(RequestPushMessage.MORNING);
//    }
//
//    @Scheduled(cron = "0 0 13 * * ?")
//    public void pushLunchMealAlarm() throws FirebaseMessagingException {
//        log.info("점심 식사 알림");
//        pushAlarm(RequestPushMessage.LUNCH);
//    }
//
//    @Scheduled(cron = "0 0 19 * * ?")
//    public void pushDinnerMealAlarm() throws FirebaseMessagingException {
//        log.info("저녁 식사 알림");
//        pushAlarm(RequestPushMessage.DINNER);
//    }
//
//    private void pushAlarm(RequestPushMessage data) throws FirebaseMessagingException {
//        Message message = getMessage(data);
//        sendMessage(message);
//    }
//
//    private Message getMessage(RequestPushMessage data) {
//        Notification notification = Notification.builder()
//                .setTitle(data.getTitle())
//                .setBody(data.getBody())
//                .build();
//        Message.Builder builder = Message.builder();
//
//        return builder.setTopic(topic)
//                .setNotification(notification)
//                .build();
//    }
//
//    public String sendMessage(Message message) throws FirebaseMessagingException {
//        return this.instance.send(message);
//    }
//}

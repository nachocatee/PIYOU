package com.b106_402jeoung.PIYOU.service;

import com.b106_402jeoung.PIYOU.dto.ChildNotiRequest;
import com.b106_402jeoung.PIYOU.dto.ChildNotiResponse;
import com.b106_402jeoung.PIYOU.dto.NotificationResponse;
import com.b106_402jeoung.PIYOU.dto.PushRequest;
import com.b106_402jeoung.PIYOU.entity.Child;
import com.b106_402jeoung.PIYOU.entity.ChildNoti;
import com.b106_402jeoung.PIYOU.entity.Notification;
import com.b106_402jeoung.PIYOU.repository.ChildNotiRepository;
import com.b106_402jeoung.PIYOU.repository.ChildRepository;
import com.b106_402jeoung.PIYOU.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PushService {
    private final ChildRepository childRepository;
    private final NotificationRepository notificationRepository;
    private final String sendUrlVal = "https://fcm.googleapis.com/fcm/send";
    @Value("${fcm.key.token}")
    private String apiKeyValue;
    private final String urlVal = "https://yusinsolution.com";
    private final ChildNotiRepository childNotiRepository;

    @SuppressWarnings("unchecked")
    public void sendPush(PushRequest pushRequest, ChildNotiRequest childNotiRequest) {
        StringBuilder urlBuilder = new StringBuilder(sendUrlVal);
        try {
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Authorization", "key=" + apiKeyValue);
            conn.setRequestProperty("Content-type", "application/json");

            JSONObject apiParams = new JSONObject();
            JSONObject dataParams = new JSONObject();
            JSONObject notificationParams = new JSONObject();

            String tokenList = pushRequest.getTokenList();

            apiParams.put("to", tokenList);

            String title = pushRequest.getTitle();

            dataParams.put("title", title);
            notificationParams.put("title", title);

            String message = pushRequest.getMessage();

            dataParams.put("message", message);
            notificationParams.put("body", message);

            String intent = pushRequest.getIntent();

            dataParams.put("intent", urlVal + intent);

            notificationParams.put("badge", 1);

            apiParams.put("data", dataParams);
            apiParams.put("notification", notificationParams);

            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(apiParams.toString());
            wr.close();

            conn.connect();

            BufferedReader rd;
            StringBuilder sb = new StringBuilder();

            rd = conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300 ?
                    new BufferedReader(new InputStreamReader(conn.getInputStream())) :
                    new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void deletePush(Long notiId) {
        childNotiRepository.deleteByNotificationId(notiId);
        notificationRepository.deleteById(notiId);
    }

    @Transactional
    public NotificationResponse registerPush(ChildNotiRequest childNotiRequest) {
        Notification notification = notificationRepository.save(childNotiRequest.getNotification()
                                                                        .toEntity());
        Child child = childRepository.findById(childNotiRequest.getChildId())
                .orElseThrow(() -> new IllegalArgumentException("해당 아이가 없습니다."));

        childNotiRepository.save(ChildNoti.builder()
                                         .child(child)
                                         .notification(notification)
                                         .build());

        return NotificationResponse.of(notification);
    }

    public List<ChildNotiResponse> getPush(UUID childId) {
        List<ChildNoti> childNotiList = childNotiRepository.findByChildIdOrderByNotificationTimeAsc(childId);

        return childNotiList.stream()
                .map(ChildNotiResponse::of)
                .collect(Collectors.toList());
    }
}
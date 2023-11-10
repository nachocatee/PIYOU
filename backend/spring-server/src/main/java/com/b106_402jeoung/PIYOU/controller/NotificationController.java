package com.b106_402jeoung.PIYOU.controller;

import com.b106_402jeoung.PIYOU.dto.NotificationRequest;
import com.b106_402jeoung.PIYOU.dto.NotificationResponse;
import com.b106_402jeoung.PIYOU.service.FCMService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/noti")
public class NotificationController {
    private final FCMService fcmService;

    @PostMapping("")
    public ResponseEntity<?> sendNotification(@RequestBody NotificationRequest request)
            throws ExecutionException, InterruptedException {
        fcmService.sendMessageToToken(request);
        return new ResponseEntity<>(NotificationResponse.builder()
                                            .status(HttpStatus.OK.value())
                                            .message("Notification has been sent."), HttpStatus.OK);
    }
}

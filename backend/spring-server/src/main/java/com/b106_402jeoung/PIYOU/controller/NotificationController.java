package com.b106_402jeoung.PIYOU.controller;

import com.b106_402jeoung.PIYOU.service.PushService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/noti")
public class NotificationController {
    private final PushService pushService;

    @PostMapping("/test")
    public void test(@RequestBody HashMap<String, String> params) {
        pushService.sendPush(params);
    }
}

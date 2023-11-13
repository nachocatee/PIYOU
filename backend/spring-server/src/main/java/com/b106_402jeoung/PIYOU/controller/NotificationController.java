package com.b106_402jeoung.PIYOU.controller;

import com.b106_402jeoung.PIYOU.dto.PushRequest;
import com.b106_402jeoung.PIYOU.service.PushService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/noti")
public class NotificationController {
    private final PushService pushService;


    @PostMapping("/register")
    public String registerToken(@RequestBody PushRequest pushRequest) {
        pushService.sendPush(pushRequest);

        return "등록완료";
    }
}

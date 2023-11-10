package com.b106_402jeoung.PIYOU.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class NotificationRequest {
    String title;
    String body;
    String topic;
    String token;
}

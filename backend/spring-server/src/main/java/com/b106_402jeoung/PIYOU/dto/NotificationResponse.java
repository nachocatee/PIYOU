package com.b106_402jeoung.PIYOU.dto;

import com.b106_402jeoung.PIYOU.entity.Notification;
import lombok.Builder;
import lombok.Value;

import java.time.LocalTime;

/**
 * DTO for {@link com.b106_402jeoung.PIYOU.entity.Notification}
 */
@Value
@Builder
public class NotificationResponse {
    Long id;
    LocalTime time;

    public static NotificationResponse of(Notification notification) {
        return NotificationResponse.builder()
                .id(notification.getId())
                .time(notification.getTime())
                .build();
    }
}
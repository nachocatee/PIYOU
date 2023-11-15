package com.b106_402jeoung.PIYOU.dto;

import com.b106_402jeoung.PIYOU.entity.Notification;
import lombok.Builder;
import lombok.Value;

/**
 * DTO for {@link com.b106_402jeoung.PIYOU.entity.Notification}
 */

@Value
@Builder
public class NotificationRequest {
    Long id;
    String time;

    public Notification toEntity() {
        return Notification.builder()
                .id(id)
                .time(time)
                .build();
    }
}
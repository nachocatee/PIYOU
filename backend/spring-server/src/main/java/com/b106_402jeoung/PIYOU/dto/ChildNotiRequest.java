package com.b106_402jeoung.PIYOU.dto;

import com.b106_402jeoung.PIYOU.entity.Child;
import com.b106_402jeoung.PIYOU.entity.ChildNoti;
import com.b106_402jeoung.PIYOU.entity.Notification;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

/**
 * DTO for {@link com.b106_402jeoung.PIYOU.entity.ChildNoti}
 */
@Value
@Builder
public class ChildNotiRequest {
    UUID childId;
    NotificationRequest notification;

    public ChildNoti toEntity(Child child, Notification notification) {
        return ChildNoti.builder()
                .child(child)
                .notification(notification)
                .build();
    }
}
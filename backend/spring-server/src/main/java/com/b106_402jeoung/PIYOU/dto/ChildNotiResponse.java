package com.b106_402jeoung.PIYOU.dto;

import com.b106_402jeoung.PIYOU.entity.ChildNoti;
import lombok.Builder;
import lombok.Value;

/**
 * DTO for {@link com.b106_402jeoung.PIYOU.entity.ChildNoti}
 */
@Value
@Builder
public class ChildNotiResponse {
    ChildResponse child;
    NotificationResponse notification;

    public static ChildNotiResponse of(ChildNoti childNoti) {
        return new ChildNotiResponse(ChildResponse.of(childNoti.getChild()),
                                     NotificationResponse.of(childNoti.getNotification()));
    }
}
package com.b106_402jeoung.PIYOU.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RequestPushMessage {
    MORNING("아침 식사 알림", "아침을 먹을 시간이야!"), LUNCH("점심 식사 알림", "점심을 먹을 시간이야!"), DINNER("저녁 식사 알림", "저녁을 먹을 시간이야!");

    final String title;
    final String body;

}


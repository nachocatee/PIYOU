package com.b106_402jeoung.PIYOU.util;

import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class CurrentDateTime {
    public static LocalTime getCurrentDateTime() {
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        return LocalTime.parse(now.format(formatter));
    }
}

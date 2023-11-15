package com.b106_402jeoung.PIYOU.dto;

import com.b106_402jeoung.PIYOU.entity.Child;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

/**
 * DTO for {@link Child}
 */
@Value
@Builder
public class ChildResponse {
    UUID id;
    String name;
    Integer level;
    Integer experience;
    StatusResponse status;


    public static ChildResponse of(Child child) {
        return ChildResponse.builder()
                .id(child.getId())
                .name(child.getName())
                .experience(child.getExperience())
                .level(child.getLevel())
                .status(StatusResponse.of(child.getStatus()))
                .build();
    }

    public static ChildResponse of(Child child, StatusResponse statusResponse) {
        return ChildResponse.builder()
                .id(child.getId())
                .name(child.getName())
                .experience(child.getExperience())
                .level(child.getLevel())
                .status(StatusResponse.of(child.getStatus(), statusResponse.getPiyouName()))
                .build();
    }
}
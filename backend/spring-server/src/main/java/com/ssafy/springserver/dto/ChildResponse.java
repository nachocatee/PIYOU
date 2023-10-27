package com.ssafy.springserver.dto;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;
/**
 * DTO for {@link com.ssafy.springserver.entity.Child}
 */
@Value
@Builder
public class ChildResponse {
    UUID id;
    String name;
    Integer level;
    Integer experience;
    StatusResponse status;

    // fromEntity
    public static ChildResponse fromEntity(com.ssafy.springserver.entity.Child child) {
        return ChildResponse.builder()
                .id(child.getId())
                .name(child.getName())
                .experience(child.getExperience())
                .level(child.getLevel())
                .status(StatusResponse.fromEntity(child.getStatus()))
                .build();
    }
}
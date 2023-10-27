package com.ssafy.springserver.dto;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;
/**
 * DTO for {@link com.ssafy.springserver.entity.Child}
 */

@Value
@Builder
public class ChildRequest {
    UUID id;
    String name;
    Integer experience;
    Integer level;
    StatusRequest status;

    public ChildRequest toEntity() {
        return ChildRequest.builder()
                .name(name)
                .experience(experience)
                .status(status)
                .build();
    }
}
package com.ssafy.springserver.dto;

import lombok.Builder;
import lombok.Value;
/**
 * DTO for {@link com.ssafy.springserver.entity.Child}
 */
@Value
@Builder
public class ChildResponse {
    String name;
    Integer experience;
    StatusResponse status;

    public ChildResponse toEntity() {
        return ChildResponse.builder()
                .name(name)
                .experience(experience)
                .status(status)
                .build();
    }
}
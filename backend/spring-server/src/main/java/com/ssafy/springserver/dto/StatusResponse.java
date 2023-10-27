package com.ssafy.springserver.dto;

import lombok.Builder;
import lombok.Value;
/**
 * DTO for {@link com.ssafy.springserver.entity.Status}
 */
@Value
@Builder
public class StatusResponse {
    Long hungry;
    Long health;

    public StatusResponse toEntity() {
        return StatusResponse.builder()
                .hungry(hungry)
                .health(health)
                .build();
    }
}
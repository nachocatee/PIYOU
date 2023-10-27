package com.ssafy.springserver.dto;

import com.ssafy.springserver.entity.Status;
import lombok.Builder;
import lombok.Value;
/**
 * DTO for {@link com.ssafy.springserver.entity.Status}
 */
@Value
@Builder
public class StatusResponse {
    Long id;
    Integer hungry;
    Integer health;

    // fromEntity
    public static StatusResponse fromEntity(Status status) {
        return StatusResponse.builder()
                .id(status.getId())
                .hungry(status.getHungry())
                .health(status.getHealth())
                .build();
    }
}
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
    Long piyouId;
    Integer hungry;
    Integer health;

    public static StatusResponse fromEntity(Status status) {
        return StatusResponse.builder()
                .id(status.getId())
                .piyouId(status.getPiyouId())
                .hungry(status.getHungry())
                .health(status.getHealth())
                .build();
    }
}
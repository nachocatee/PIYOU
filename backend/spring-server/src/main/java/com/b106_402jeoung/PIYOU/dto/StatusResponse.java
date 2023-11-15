package com.b106_402jeoung.PIYOU.dto;

import com.b106_402jeoung.PIYOU.entity.Status;
import lombok.Builder;
import lombok.Value;

/**
 * DTO for {@link Status}
 */
@Value
@Builder
public class StatusResponse {
    Long id;
    Long piyouId;
    String piyouName;

    public static StatusResponse of(Status status) {
        return StatusResponse.builder()
                .id(status.getId())
                .piyouId(status.getPiyouId())
                .build();
    }

    public static StatusResponse of(Status status, String piyouName) {
        return StatusResponse.builder()
                .id(status.getId())
                .piyouName(piyouName)
                .piyouId(status.getPiyouId())
                .build();
    }
}
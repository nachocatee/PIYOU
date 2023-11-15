package com.b106_402jeoung.PIYOU.dto;

import com.b106_402jeoung.PIYOU.entity.Status;
import lombok.Builder;
import lombok.Value;

/**
 * DTO for {@link Status}
 */
@Value
@Builder
public class StatusRequest {
    Long piyouId;

    public Status toEntity() {
        return Status.builder()
                .piyouId(piyouId)
                .build();
    }
}
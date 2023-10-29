package com.ssafy.springserver.dto;

import com.ssafy.springserver.entity.Collected;
import lombok.Builder;
import lombok.Value;
/**
 * DTO for {@link Collected}
 */
@Value
@Builder
public class CollectedResponse {
    Long id;
    PiyouResponse piyou;

    public static CollectedResponse fromEntity(Collected collected) {
        return CollectedResponse.builder()
                .id(collected.getId())
                .piyou(PiyouResponse.fromEntity(collected.getPiyou()))
                .build();
    }
}
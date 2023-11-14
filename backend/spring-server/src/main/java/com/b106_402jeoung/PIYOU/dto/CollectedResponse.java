package com.b106_402jeoung.PIYOU.dto;

import com.b106_402jeoung.PIYOU.entity.Collected;
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

    public static CollectedResponse of(Collected collected) {
        return CollectedResponse.builder()
                .id(collected.getId())
                .piyou(PiyouResponse.of(collected.getPiyou()))
                .build();
    }
}
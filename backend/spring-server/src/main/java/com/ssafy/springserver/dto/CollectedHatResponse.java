package com.ssafy.springserver.dto;

import com.ssafy.springserver.entity.CollectedHat;
import lombok.Builder;
import lombok.Value;

/**
 * DTO for {@link com.ssafy.springserver.entity.CollectedHat}
 */
@Value
@Builder
public class CollectedHatResponse {
    Long id;
    HatResponse hat;
    ChildResponse child;

    public static CollectedHatResponse fromEntity(CollectedHat collectedHat) {
        return CollectedHatResponse.builder()
                .id(collectedHat.getId())
                .hat(HatResponse.fromEntity(collectedHat.getHat()))
                .child(ChildResponse.fromEntity(collectedHat.getChild()))
                .build();
    }
}
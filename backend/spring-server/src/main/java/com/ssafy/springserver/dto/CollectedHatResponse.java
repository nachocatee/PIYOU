package com.ssafy.springserver.dto;

import com.ssafy.springserver.entity.Child;
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
    Child child;

    public static CollectedHatResponse fromEntity(CollectedHat collectedHat) {
        return CollectedHatResponse.builder()
                .id(collectedHat.getId())
                .hat(HatResponse.fromEntity(collectedHat.getHat()))
                .child(collectedHat.getChild())
                .build();
    }
}
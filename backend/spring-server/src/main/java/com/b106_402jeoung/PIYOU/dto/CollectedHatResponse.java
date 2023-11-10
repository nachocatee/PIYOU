package com.b106_402jeoung.PIYOU.dto;

import com.b106_402jeoung.PIYOU.entity.CollectedHat;
import lombok.Builder;
import lombok.Value;

/**
 * DTO for {@link CollectedHat}
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
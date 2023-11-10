package com.b106_402jeoung.PIYOU.dto;

import com.b106_402jeoung.PIYOU.entity.Hat;
import lombok.Builder;
import lombok.Value;

/**
 * DTO for {@link Hat}
 */
@Value
@Builder
public class HatResponse {
    Long id;
    String engName;
    String name;

    public static HatResponse fromEntity(Hat hat) {
        return HatResponse.builder()
                .id(hat.getId())
                .engName(hat.getEngName())
                .name(hat.getName())
                .build();
    }
}
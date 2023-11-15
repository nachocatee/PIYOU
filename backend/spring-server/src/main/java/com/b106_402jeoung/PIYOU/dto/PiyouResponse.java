package com.b106_402jeoung.PIYOU.dto;

import com.b106_402jeoung.PIYOU.entity.Piyou;
import lombok.Builder;
import lombok.Value;

/**
 * DTO for {@link Piyou}
 */
@Value
@Builder
public class PiyouResponse {
    Long id;
    String name;
    String engName;
    Integer degree;

    public static PiyouResponse of(Piyou piyou) {
        return PiyouResponse.builder()
                .id(piyou.getId())
                .name(piyou.getName())
                .engName(piyou.getEngName())
                .degree(piyou.getDegree())
                .build();
    }
}
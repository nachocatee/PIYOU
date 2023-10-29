package com.ssafy.springserver.dto;

import com.ssafy.springserver.entity.Piyou;
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
    String path;
    Integer degree;

    public static PiyouResponse fromEntity(Piyou piyou) {
        return PiyouResponse.builder()
                .id(piyou.getId())
                .name(piyou.getName())
                .engName(piyou.getEngName())
                .path(piyou.getPath())
                .degree(piyou.getDegree())
                .build();
    }
}
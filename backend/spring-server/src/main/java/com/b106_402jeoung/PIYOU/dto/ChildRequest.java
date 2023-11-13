package com.b106_402jeoung.PIYOU.dto;

import com.b106_402jeoung.PIYOU.entity.Child;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

/**
 * DTO for {@link Child}
 */

@Value
@Builder
public class ChildRequest {
    UUID id;
    String name;
    Integer experience;
    Integer level;
    StatusRequest status;
    String token;

    public ChildRequest toEntity() {
        return ChildRequest.builder()
                .name(name)
                .experience(experience)
                .status(status)
                .token(token)
                .build();
    }
}
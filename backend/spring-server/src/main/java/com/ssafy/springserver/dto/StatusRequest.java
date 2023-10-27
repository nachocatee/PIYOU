package com.ssafy.springserver.dto;

import lombok.Builder;
import lombok.Value;
/**
 * DTO for {@link com.ssafy.springserver.entity.Status}
 */
@Value
@Builder
public class StatusRequest {
    Long piyouId;
    Long hungry;
    Long health;
}
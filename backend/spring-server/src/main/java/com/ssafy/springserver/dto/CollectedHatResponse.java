package com.ssafy.springserver.dto;

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
    ChildWithPiyouResponse child;
}
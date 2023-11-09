package com.ssafy.springserver.dto;

import lombok.Builder;
import lombok.Value;
/**
 * DTO for {@link com.ssafy.springserver.entity.Hat}
 */
@Value
@Builder
public class HatRequest {
    String engName;
    String name;
}
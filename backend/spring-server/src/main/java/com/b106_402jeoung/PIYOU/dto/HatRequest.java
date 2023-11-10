package com.b106_402jeoung.PIYOU.dto;

import com.b106_402jeoung.PIYOU.entity.Hat;
import lombok.Builder;
import lombok.Value;

/**
 * DTO for {@link Hat}
 */
@Value
@Builder
public class HatRequest {
    String engName;
    String name;
}
package com.b106_402jeoung.PIYOU.dto;

import com.b106_402jeoung.PIYOU.entity.Child;
import lombok.Builder;
import lombok.Value;

import java.util.List;

/**
 * DTO for {@link Child}
 */
@Value
@Builder
public class ChildWithPiyouResponse {
    List<CollectedResponse> collects;
}
package com.ssafy.springserver.dto;

import com.ssafy.springserver.entity.Child;
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
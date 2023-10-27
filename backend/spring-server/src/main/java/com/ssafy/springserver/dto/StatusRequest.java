package com.ssafy.springserver.dto;

import lombok.Value;

import java.io.Serializable;
/**
 * DTO for {@link com.ssafy.springserver.entity.Status}
 */
@Value
public class StatusRequest implements Serializable {
    Long id;
    Long piyouId;
    Long hungry;
    Long health;
}
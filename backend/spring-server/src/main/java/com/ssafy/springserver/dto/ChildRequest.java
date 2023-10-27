package com.ssafy.springserver.dto;

import lombok.Value;

import java.io.Serializable;
import java.util.UUID;
/**
 * DTO for {@link com.ssafy.springserver.entity.Child}
 */
@Value
public class ChildRequest implements Serializable {
    UUID id;
    String name;
    Integer experience;
    StatusRequest status;
}
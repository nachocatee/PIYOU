package com.ssafy.springserver.entity.collected;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Collected {
    @EmbeddedId
    private CollectedId collectedId;
}
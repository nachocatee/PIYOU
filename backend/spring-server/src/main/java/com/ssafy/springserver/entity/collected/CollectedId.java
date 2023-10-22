package com.ssafy.springserver.entity.collected;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class CollectedId implements Serializable {
    @Column(name = "child_id")
    private UUID childId;
    @Column(name = "piyou_id")
    private Integer piyouId;
}
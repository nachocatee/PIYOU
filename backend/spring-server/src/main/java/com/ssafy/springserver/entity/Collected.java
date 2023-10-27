package com.ssafy.springserver.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "collected")
public class Collected {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "child_id", nullable = false)
    private Long childId;

    @Column(name = "piyou_id", nullable = false)
    private Long piyouId;
}
package com.ssafy.springserver.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "collected")
public class Collected {
    @Id
    @Column(name = "collected_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;

    @ManyToOne
    @JoinColumn(name = "piyou_id")
    private Piyou piyou;
}
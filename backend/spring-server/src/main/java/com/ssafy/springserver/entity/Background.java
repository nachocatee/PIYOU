package com.ssafy.springserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "background")
public class Background {
    @Id
    @Column(name = "background_id", nullable = false)
    private Long id;

    @Column(length = 330)
    private String path;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;
}
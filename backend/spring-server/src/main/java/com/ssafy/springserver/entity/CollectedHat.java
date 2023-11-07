package com.ssafy.springserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "collected_hat")
public class CollectedHat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collected_hat_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hat_id")
    private Hat hat;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;
}
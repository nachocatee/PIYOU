package com.ssafy.springserver.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
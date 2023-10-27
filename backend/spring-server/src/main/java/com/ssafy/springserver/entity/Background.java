package com.ssafy.springserver.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Background {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "background_id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true, length = 330)
    private String path;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "child_id", nullable = false)
    private Child child;
}
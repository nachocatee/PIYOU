package com.ssafy.springserver.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Background {
    @Id
    @Column(name = "background_id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true, length = 330)
    private String path;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;
}
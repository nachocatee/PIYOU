package com.ssafy.springserver.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Piyou {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "piyou_id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String name;

    @Column(nullable = false, unique = true, length = 330)
    private String path;
}
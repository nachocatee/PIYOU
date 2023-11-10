package com.b106_402jeoung.PIYOU.entity;

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
public class Piyou {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "piyou_id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String name;

    @Column(name = "eng_name")
    private String engName;

    private Integer degree;
}
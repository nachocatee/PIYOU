package com.b106_402jeoung.PIYOU.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "hat")
public class Hat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hat_id", nullable = false)
    private Long id;

    @Column(length = 20)
    private String engName;

    @Column(length = 20)
    private String name;
}
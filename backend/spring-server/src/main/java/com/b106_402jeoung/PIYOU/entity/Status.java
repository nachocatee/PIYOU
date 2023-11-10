package com.b106_402jeoung.PIYOU.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id", nullable = false)
    private Long id;

    @Setter
    @Column(name = "piyou_id")
    private Long piyouId;

    @PrePersist
    private void prePersist() {
        this.piyouId = 1L;
    }
}
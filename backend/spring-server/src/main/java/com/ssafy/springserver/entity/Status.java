package com.ssafy.springserver.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Column(name = "piyou_id")
    private Long piyouId;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer hungry;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer health;

    @PrePersist
    private void prePersist() {
        this.piyouId = 1L;
        this.hungry = 0;
        this.health = 0;
    }
}
package com.ssafy.springserver.entity;

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

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer hungry;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer health;
    private Boolean death;

    public void piyouDeath() {
        this.death = true;
    }

    @PrePersist
    private void prePersist() {
        this.piyouId = 1L;
        this.hungry = 0;
        this.health = 0;
        this.death = false;
    }
}
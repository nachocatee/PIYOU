package com.ssafy.springserver.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Child {
    @Id
    @Column(name = "child_id", nullable = false, length = 16)
    private UUID id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "level")
    private Integer level;

    @Column(name = "experience")
    private Integer experience;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @PrePersist
    public void prePersist() {
        if (this.id == null) {
            // 16자리 uuid
            this.id = UUID.randomUUID();
        }
        this.level = 1;
        this.experience = 0;
    }
}
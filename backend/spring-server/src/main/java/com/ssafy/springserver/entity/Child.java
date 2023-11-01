package com.ssafy.springserver.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
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

    private Integer level;

    private Integer experience;

    @Setter
    private Integer starved;
    private Boolean isMeal;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @OneToMany(mappedBy = "child", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Collected> collects;
    @PrePersist
    public void prePersist() {
        if (this.id == null) {
            // 16자리 uuid
            this.id = UUID.randomUUID();
        }
        this.level = 1;
        this.experience = 0;
        this.starved = 0;
        this.isMeal = false;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateExperience(Integer experience) {
        this.experience += experience;
        this.level += this.experience / 100;
        this.experience %= 100;
    }
}
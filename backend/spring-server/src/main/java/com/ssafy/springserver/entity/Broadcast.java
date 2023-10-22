package com.ssafy.springserver.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Broadcast {
    @Id
    @Column(name = "broadcast_id", nullable = false)
    private Long id;

    @Column(length = 20)
    private String name;

    @CreatedDate
    private Timestamp broadcastTime;

    private Integer count;

    private Integer like;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;
}
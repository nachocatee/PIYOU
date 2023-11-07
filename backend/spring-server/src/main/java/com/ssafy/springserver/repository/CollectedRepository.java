package com.ssafy.springserver.repository;

import com.ssafy.springserver.entity.Child;
import com.ssafy.springserver.entity.Collected;
import com.ssafy.springserver.entity.Piyou;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CollectedRepository extends JpaRepository<Collected, Long> {
    Optional<Collected> findByChildAndPiyou(Child child, Piyou piyou);

    List<Collected> findByChildId(UUID id);
}
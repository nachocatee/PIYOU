package com.b106_402jeoung.PIYOU.repository;

import com.b106_402jeoung.PIYOU.entity.Child;
import com.b106_402jeoung.PIYOU.entity.Collected;
import com.b106_402jeoung.PIYOU.entity.Piyou;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CollectedRepository extends JpaRepository<Collected, Long> {
    Optional<Collected> findByChildAndPiyou(Child child, Piyou piyou);

    List<Collected> findByChildId(UUID id);
}
package com.b106_402jeoung.PIYOU.repository;

import com.b106_402jeoung.PIYOU.entity.Child;
import com.b106_402jeoung.PIYOU.entity.CollectedHat;
import com.b106_402jeoung.PIYOU.entity.Hat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CollectedHatRepository extends JpaRepository<CollectedHat, Long> {
    List<CollectedHat> findByChildId(UUID id);

    Optional<CollectedHat> findByChildAndHat(Child child, Hat hat);
}
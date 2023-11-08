package com.ssafy.springserver.repository;

import com.ssafy.springserver.entity.Child;
import com.ssafy.springserver.entity.CollectedHat;
import com.ssafy.springserver.entity.Hat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface CollectedHatRepository extends JpaRepository<CollectedHat, Long> {
    List<CollectedHat> findByChildId(UUID id);

    Optional<CollectedHat> findByChildAndHat(Child child, Hat hat);
}
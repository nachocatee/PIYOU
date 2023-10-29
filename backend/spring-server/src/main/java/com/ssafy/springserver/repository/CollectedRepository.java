package com.ssafy.springserver.repository;

import com.ssafy.springserver.entity.Child;
import com.ssafy.springserver.entity.Collected;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
public interface CollectedRepository extends JpaRepository<Collected, Long> {
    List<Collected> findByChildId(UUID id);
    List<Collected> findByChild(Child child);
}
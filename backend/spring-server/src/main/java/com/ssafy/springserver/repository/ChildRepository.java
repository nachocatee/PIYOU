package com.ssafy.springserver.repository;

import com.ssafy.springserver.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ChildRepository extends JpaRepository<Child, UUID> {
    List<Child> findAllByIsMealFalse();
}
package com.ssafy.springserver.repository;

import com.ssafy.springserver.entity.Hat;
import org.springframework.data.jpa.repository.JpaRepository;
public interface HatRepository extends JpaRepository<Hat, Long> {
}
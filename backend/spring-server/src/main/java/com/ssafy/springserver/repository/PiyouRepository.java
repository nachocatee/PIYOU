package com.ssafy.springserver.repository;

import com.ssafy.springserver.entity.Piyou;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PiyouRepository extends JpaRepository<Piyou, Long> {
    Optional<Piyou> findByEngName(String engName);
}
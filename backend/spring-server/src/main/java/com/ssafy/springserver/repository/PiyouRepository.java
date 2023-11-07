package com.ssafy.springserver.repository;

import com.ssafy.springserver.entity.Piyou;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PiyouRepository extends JpaRepository<Piyou, Long> {
}
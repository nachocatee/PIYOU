package com.b106_402jeoung.PIYOU.repository;

import com.b106_402jeoung.PIYOU.entity.Piyou;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PiyouRepository extends JpaRepository<Piyou, Long> {
    Optional<Piyou> findByEngName(String engName);
}
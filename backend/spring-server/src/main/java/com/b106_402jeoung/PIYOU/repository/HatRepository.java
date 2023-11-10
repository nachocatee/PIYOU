package com.b106_402jeoung.PIYOU.repository;

import com.b106_402jeoung.PIYOU.entity.Hat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface HatRepository extends JpaRepository<Hat, Long> {
    List<Hat> findByNameIn(Collection<String> names);

    Optional<Hat> findByName(String name);
}
package com.ssafy.springserver.repository;

import com.ssafy.springserver.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
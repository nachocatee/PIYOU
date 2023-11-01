package com.ssafy.springserver.repository;

import com.ssafy.springserver.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface StatusRepository extends JpaRepository<Status, Long> {
}
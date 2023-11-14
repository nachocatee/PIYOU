package com.b106_402jeoung.PIYOU.repository;

import com.b106_402jeoung.PIYOU.entity.ChildNoti;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ChildNotiRepository extends JpaRepository<ChildNoti, Long> {
    void deleteByNotificationId(Long id);

    List<ChildNoti> findByChildIdOrderByNotificationTimeAsc(UUID id);
}
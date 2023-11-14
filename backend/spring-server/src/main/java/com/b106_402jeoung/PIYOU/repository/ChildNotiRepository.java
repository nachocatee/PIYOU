package com.b106_402jeoung.PIYOU.repository;

import com.b106_402jeoung.PIYOU.entity.ChildNoti;
import com.b106_402jeoung.PIYOU.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChildNotiRepository extends JpaRepository<ChildNoti, Long> {
    Optional<ChildNoti> findByNotificationId(Long id);
    Optional<ChildNoti> findByNotification(Notification notification);
    List<ChildNoti> findAllByChildId(UUID id);
}
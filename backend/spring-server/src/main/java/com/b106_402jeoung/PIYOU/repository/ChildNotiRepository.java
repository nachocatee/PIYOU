package com.b106_402jeoung.PIYOU.repository;

import com.b106_402jeoung.PIYOU.entity.ChildNoti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ChildNotiRepository extends JpaRepository<ChildNoti, Long> {
    void deleteByNotificationId(Long id);

    List<ChildNoti> findByChildIdOrderByNotificationTimeAsc(UUID id);

    // 시간이 현재시간보다 10분전인 데이터를 찾는 쿼리
    @Query(value = "SELECT * FROM child_noti WHERE notification_id IN (SELECT notification_id From notification WHERE TIME_FORMAT(time, '%H:%i') = TIME_FORMAT(CURTIME()-INTERVAL 10 MINUTE, '%H:%i'))", nativeQuery = true)
    List<ChildNoti> findOldNoti();
}

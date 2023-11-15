package com.b106_402jeoung.PIYOU.service;

import com.b106_402jeoung.PIYOU.entity.Child;
import com.b106_402jeoung.PIYOU.repository.ChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchedulerService {
    private final ChildRepository childRepository;

    @Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
    private int batchSize;

    @PersistenceContext
    private final EntityManager entityManager;

    @Transactional
    public void updateChildExp() {
        List<Child> childList = childRepository.findAllByIsMealFalse();
        int count = 0;

        for (Child child : childList) {
            child.minusExperience(4);
            if (++count % batchSize == 0) {
                entityManager.flush();
            }
        }

        entityManager.flush();
        entityManager.clear();
    }

    @Transactional
    public void updateChildIsMeal() {
        List<Child> childList = childRepository.findAllByIsMealTrue();
        int count = 0;

        for (Child child : childList) {
            child.isHungry();
            if (++count % batchSize == 0) {
                entityManager.flush();
            }
        }

        entityManager.flush();
        entityManager.clear();
    }
}

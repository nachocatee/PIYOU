package com.b106_402jeoung.PIYOU.service;

import com.b106_402jeoung.PIYOU.dto.ChildRequest;
import com.b106_402jeoung.PIYOU.dto.ChildResponse;
import com.b106_402jeoung.PIYOU.dto.StatusResponse;
import com.b106_402jeoung.PIYOU.entity.*;
import com.b106_402jeoung.PIYOU.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChildService {

    private final ChildRepository childRepository;
    private final StatusRepository statusRepository;
    private final PiyouRepository piyouRepository;
    private final CollectedRepository collectedRepository;
    private final HatRepository hatRepository;
    private final CollectedHatRepository collectedHatRepository;

    @Transactional
    public ChildResponse createChild(ChildRequest childRequest) {
        Status status = statusRepository.save(new Status());
        Child child = childRepository.save(Child.builder()
                                                   .name(childRequest.getName())
                                                   .status(status)
                                                   .build());
        Piyou piyou = piyouRepository.findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("해당 피유가 없습니다."));
        List<String> hatNameList = List.of("hat_empty", "hat_santa3", "hat_cap");
        List<Hat> hatList = hatRepository.findByNameIn(hatNameList);

        for (Hat hat : hatList) {
            collectedHatRepository.save(CollectedHat.builder()
                                                .child(child)
                                                .hat(hat)
                                                .build());
        }

        collectedRepository.save(Collected.builder()
                                         .child(child)
                                         .piyou(piyou)
                                         .build());

        return ChildResponse.of(child, StatusResponse.of(status, piyou.getEngName()));
    }

    public ChildResponse getChild(UUID childId) {
        Child child = childRepository.findById(childId)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이가 없습니다."));
        Piyou piyou = piyouRepository.findById(child.getStatus()
                                                       .getPiyouId())
                .orElseThrow(() -> new IllegalArgumentException("해당 피유가 없습니다."));

        return ChildResponse.of(child, StatusResponse.of(child.getStatus(), piyou.getEngName()));
    }

    @Transactional
    public ChildResponse updateChild(UUID childId, ChildRequest child) {
        Child childEntity = childRepository.findById(childId)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이가 없습니다."));
        Piyou piyou = piyouRepository.findById(childEntity.getStatus()
                                                       .getPiyouId())
                .orElseThrow(() -> new IllegalArgumentException("해당 피유가 없습니다."));

        if (child.getName() != null) {
            childEntity.updateName(child.getName());
        }

        if (child.getExperience() != null) {
            childEntity.updateExperience(child.getExperience());
            childEntity.ateMeal();
        }

        childRepository.save(childEntity);
        return ChildResponse.of(childEntity,
                                StatusResponse.of(childEntity.getStatus(), piyou.getEngName()));
    }

    public void updateChildExp() {
        List<Child> childList = childRepository.findAllByIsMealFalse();
        for (Child child : childList) {
            child.minusExperience(4);
            childRepository.save(child);
        }
    }

    public void updateChildToken(UUID childId, String token) {
        Child child = childRepository.findById(childId)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이가 없습니다."));

        child.setToken(token);
        childRepository.save(child);
    }
}

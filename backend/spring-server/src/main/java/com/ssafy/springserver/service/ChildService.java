package com.ssafy.springserver.service;

import com.ssafy.springserver.dto.ChildRequest;
import com.ssafy.springserver.dto.ChildResponse;
import com.ssafy.springserver.dto.StatusResponse;
import com.ssafy.springserver.entity.*;
import com.ssafy.springserver.repository.*;
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
        Child child = childRepository.save(Child.builder().name(childRequest.getName()).status(status).build());
        Piyou piyou = piyouRepository.findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("해당 피유가 없습니다."));
        Hat hat = hatRepository.findByName("hat_empty").orElseThrow(
                () -> new IllegalArgumentException("해당 모자가 없습니다.")
        );

        collectedHatRepository.save(
                CollectedHat.builder()
                        .child(child)
                        .hat(hat)
                        .build()
        );

        collectedRepository.save(
                Collected.builder()
                        .child(child)
                        .piyou(piyou)
                        .build()
        );

        return ChildResponse.fromEntity(child, StatusResponse.fromEntity(status, piyou.getEngName()));
    }

    public ChildResponse getChild(UUID childId) {
        Child child = childRepository.findById(childId).orElseThrow(() -> new IllegalArgumentException("해당 아이가 없습니다."));
        Piyou piyou = piyouRepository.findById(child.getStatus().getPiyouId())
                .orElseThrow(() -> new IllegalArgumentException("해당 피유가 없습니다."));

        return ChildResponse.fromEntity(child, StatusResponse.fromEntity(child.getStatus(), piyou.getEngName()));
    }

    @Transactional
    public ChildResponse updateChild(UUID childId, ChildRequest child) {
        Child childEntity = childRepository.findById(childId)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이가 없습니다."));
        Piyou piyou = piyouRepository.findById(childEntity.getStatus().getPiyouId())
                .orElseThrow(() -> new IllegalArgumentException("해당 피유가 없습니다."));

        if (child.getName() != null) {
            childEntity.updateName(child.getName());
        }

        if (child.getExperience() != null) {
            childEntity.updateExperience(child.getExperience());
        }

        childRepository.save(childEntity);
        return ChildResponse.fromEntity(childEntity,
                StatusResponse.fromEntity(childEntity.getStatus(), piyou.getEngName()));
    }
    public void updateChildExp() {
        List<Child> childList = childRepository.findAllByIsMealFalse();
        for (Child child : childList) {
            child.minusExperience(4);
            childRepository.save(child);
        }
    }
}

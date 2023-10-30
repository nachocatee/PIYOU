package com.ssafy.springserver.service;
import com.ssafy.springserver.dto.ChildRequest;
import com.ssafy.springserver.dto.ChildResponse;
import com.ssafy.springserver.entity.Child;
import com.ssafy.springserver.entity.Status;
import com.ssafy.springserver.repository.ChildRepository;
import com.ssafy.springserver.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChildService {

    private final ChildRepository childRepository;
    private final StatusRepository statusRepository;
    private final PushService pushService;
    public ChildResponse createChild(ChildRequest childRequest) {
        Status status = statusRepository.save(new Status());
        Child child = childRepository.save(Child.builder().name(childRequest.getName()).status(status).build());

        return ChildResponse.fromEntity(child);
    }
    public ChildResponse getChild(UUID childId) {
        Child child = childRepository.findById(childId).orElseThrow(() -> new IllegalArgumentException("해당 아이가 없습니다."));
        return ChildResponse.fromEntity(child);
    }
    public ChildResponse updateChild(UUID childId, ChildRequest child) {
        Child childEntity = childRepository.findById(childId).orElseThrow(() -> new IllegalArgumentException("해당 아이가 없습니다."));

        if (child.getName() != null) {
            childEntity.updateName(child.getName());
        }

        if (child.getExperience() != null) {
            childEntity.updateExperience(child.getExperience());
        }

        childRepository.save(childEntity);
        return ChildResponse.fromEntity(childEntity);
    }

    /**
     * 아이가 7일 굶으면 현재 status 피유 사망
     * schedule로 매일매일 체크
     * 밥을 먹었다면 starved를 0으로 초기화
     * starved가 5 이상이면 푸시 알림
     * 아이가 굶었다면 starved를 1씩 증가
     *
     * @param childId 아이 id
     */
    public void checkChild(UUID childId) {
        Child child = childRepository.findById(childId).orElseThrow(() -> new IllegalArgumentException("해당 아이가 없습니다."));
        updateStarved(child);
        childRepository.save(child);

        pushService.alertStarved(child);
    }
    private void updateStarved(Child child) {
        if (child.getIsMeal()) {
            child.setStarved(0);
        } else {
            {
                if (child.getStarved() >= 7) {
                    child.getStatus().piyouDeath();
                }
                child.setStarved(child.getStarved() + 1);
            }
        }
    }
}

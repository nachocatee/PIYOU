package com.ssafy.springserver.service;

import com.ssafy.springserver.dto.CollectedHatResponse;
import com.ssafy.springserver.dto.HatResponse;
import com.ssafy.springserver.entity.Child;
import com.ssafy.springserver.entity.CollectedHat;
import com.ssafy.springserver.entity.Hat;
import com.ssafy.springserver.repository.ChildRepository;
import com.ssafy.springserver.repository.CollectedHatRepository;
import com.ssafy.springserver.repository.HatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HatService {

    private final CollectedHatRepository collectedHatRepository;
    private final ChildRepository childRepository;
    private final HatRepository hatRepository;

    public List<HatResponse> getHat(UUID childId) {
        List<CollectedHat> collectedHats = collectedHatRepository.findByChildId(childId);
        return collectedHats.stream()
                .map(collectedHat -> HatResponse.fromEntity(collectedHat.getHat()))
                .collect(Collectors.toList());
    }

    @Transactional
    public CollectedHatResponse createHat(UUID childId, String hatName) {
        Child child = childRepository.findById(childId)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이를 찾을 수 없습니다."));

        Hat hat = hatRepository.findByName(hatName)
                .orElseThrow(() -> new IllegalArgumentException("해당 모자를 찾을 수 없습니다."));

        CollectedHat collectedHat = collectedHatRepository.findByChildAndHat(child, hat)
                .orElse(null);

        // 이미 존재 하는 경우 에러를 던져줘야 함
        assert collectedHat == null : "이미 모자를 소유하고 있습니다.";

        CollectedHat createCollectHat = collectedHatRepository.save(CollectedHat.builder()
                                                                            .child(child)
                                                                            .hat(hat)
                                                                            .build());
        return CollectedHatResponse.fromEntity(createCollectHat);
    }
}

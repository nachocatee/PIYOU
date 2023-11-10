package com.b106_402jeoung.PIYOU.service;

import com.b106_402jeoung.PIYOU.dto.CollectedResponse;
import com.b106_402jeoung.PIYOU.dto.StatusResponse;
import com.b106_402jeoung.PIYOU.entity.Child;
import com.b106_402jeoung.PIYOU.entity.Collected;
import com.b106_402jeoung.PIYOU.entity.Piyou;
import com.b106_402jeoung.PIYOU.entity.Status;
import com.b106_402jeoung.PIYOU.repository.ChildRepository;
import com.b106_402jeoung.PIYOU.repository.CollectedRepository;
import com.b106_402jeoung.PIYOU.repository.PiyouRepository;
import com.b106_402jeoung.PIYOU.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PiyouService {
    private final CollectedRepository collectedRepository;
    private final ChildRepository childRepository;
    private final PiyouRepository piyouRepository;
    private final StatusRepository statusRepository;

    public List<CollectedResponse> getPiyouList(UUID childId) {
        List<Collected> collectedList = collectedRepository.findByChildId(childId);
        return collectedList.stream()
                .map(CollectedResponse::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public CollectedResponse createPiyou(UUID childId, String piyouName) {
        Child child = childRepository.findById(childId)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이가 없습니다."));
        Piyou piyou = piyouRepository.findByEngName(piyouName)
                .orElseThrow(() -> new IllegalArgumentException("해당 피유가 없습니다."));
        Collected collected = collectedRepository.findByChildAndPiyou(child, piyou)
                .orElse(null);

        if (collected == null) {
            return CollectedResponse.fromEntity(collectedRepository.save(Collected.builder()
                                                                                 .child(child)
                                                                                 .piyou(piyou)
                                                                                 .build()));
        } else {
            throw new IllegalArgumentException("이미 등록된 피유입니다.");
        }
    }

    @Transactional
    public StatusResponse createCurrentPiyou(UUID childId, Long piyouId) {
        Status status = new Status();
        Child child = childRepository.findById(childId)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이가 없습니다."));
        status.setPiyouId(piyouId);
        statusRepository.save(status);

        child.setStatus(status);

        childRepository.save(child);
        return StatusResponse.fromEntity(status);
    }
}

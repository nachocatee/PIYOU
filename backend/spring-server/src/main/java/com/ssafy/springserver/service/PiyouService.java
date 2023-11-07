package com.ssafy.springserver.service;

import com.ssafy.springserver.dto.CollectedResponse;
import com.ssafy.springserver.dto.StatusResponse;
import com.ssafy.springserver.entity.Child;
import com.ssafy.springserver.entity.Collected;
import com.ssafy.springserver.entity.Piyou;
import com.ssafy.springserver.entity.Status;
import com.ssafy.springserver.repository.ChildRepository;
import com.ssafy.springserver.repository.CollectedRepository;
import com.ssafy.springserver.repository.PiyouRepository;
import com.ssafy.springserver.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        return collectedList.stream().map(CollectedResponse::fromEntity).collect(Collectors.toList());
    }

    public CollectedResponse createPiyou(UUID childId, Long piyouId) {
        Child child = childRepository.findById(childId).orElseThrow(() -> new IllegalArgumentException("해당 아이가 없습니다."));
        Piyou piyou = piyouRepository.findById(piyouId).orElseThrow(() -> new IllegalArgumentException("해당 피유가 없습니다."));
        Collected collected = collectedRepository.findByChildAndPiyou(child, piyou).orElse(null);
        if (collected == null) {
            return CollectedResponse.fromEntity(collectedRepository.save(
                    Collected.builder()
                            .child(child)
                            .piyou(piyou)
                            .build()));
        } else {
            throw new IllegalArgumentException("이미 등록된 피유입니다.");
        }
    }

    public StatusResponse createCurrentPiyou(UUID childId, Long piyouId) {
        Status status = new Status();
        Child child = childRepository.findById(childId).orElseThrow(() -> new IllegalArgumentException("해당 아이가 없습니다."));
        status.setPiyouId(piyouId);
        statusRepository.save(status);

        child.setStatus(status);

        childRepository.save(child);
        return StatusResponse.fromEntity(status);
    }
}

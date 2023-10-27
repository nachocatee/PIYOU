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

        childEntity.updateName(child.getName());

        childRepository.save(childEntity);
        return ChildResponse.fromEntity(childEntity);
    }
}

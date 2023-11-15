package com.b106_402jeoung.PIYOU.service;

import com.b106_402jeoung.PIYOU.entity.Child;
import com.b106_402jeoung.PIYOU.repository.ChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final ChildRepository childRepository;

    @Transactional
    public void setToken(UUID childId, Map<String, String> token) {
        Child child = childRepository.findById(childId)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이가 없습니다."));

        child.setToken(token.get("token"));

        childRepository.save(child);
    }
}

package com.b106_402jeoung.PIYOU.controller;

import com.b106_402jeoung.PIYOU.service.HatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hat")
public class HatController {
    private final HatService hatService;

    /**
     * 아이가 수집한 모자 정보 조회
     *
     * @param childId 아이 식별자
     * @return 모자 정보
     */
    @GetMapping("/{childId}")
    public ResponseEntity<?> getHat(@PathVariable UUID childId) {
        return ResponseEntity.ok(hatService.getHat(childId));
    }

    /**
     * 아이 모자 등록
     *
     * @param childId 아이 식별자
     * @param hatName 모자 식별자
     * @return 모자 정보
     */
    @PostMapping("/{childId}/{hatName}")
    public ResponseEntity<?> createHat(@PathVariable UUID childId, @PathVariable String hatName) {
        return ResponseEntity.ok(hatService.createHat(childId, hatName));
    }
}
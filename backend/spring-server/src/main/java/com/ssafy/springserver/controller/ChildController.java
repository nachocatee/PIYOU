package com.ssafy.springserver.controller;
import com.ssafy.springserver.dto.ChildRequest;
import com.ssafy.springserver.dto.ChildResponse;
import com.ssafy.springserver.service.ChildService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/child")
public class ChildController {
    private final ChildService childService;

    /**
     * 아이 생성
     *
     * @param child 아이 정보
     * @return 생성된 아이 정보
     */
    @PostMapping()
    public ResponseEntity<ChildResponse> createChild(@RequestBody ChildRequest child) {
        return ResponseEntity.ok(childService.createChild(child));
    }

    /**
     * 아이 조회
     *
     * @param childId 아이 id
     * @return 아이 정보
     */
    @GetMapping("/{childId}")
    public ResponseEntity<ChildResponse> getChild(@PathVariable UUID childId) {
        return ResponseEntity.ok(childService.getChild(childId));
    }

    /**
     * 아이 정보 수정
     *
     * @param childId 아이 id
     * @param child   수정할 아이 정보
     * @return 수정된 아이 정보
     */
    @PutMapping("/{childId}")
    public ResponseEntity<ChildResponse> updateChild(@PathVariable UUID childId, @RequestBody ChildRequest child) {
        return ResponseEntity.ok(childService.updateChild(childId, child));
    }

    /**
     * 아이 7일 굶으면 현재 피유
     */
}
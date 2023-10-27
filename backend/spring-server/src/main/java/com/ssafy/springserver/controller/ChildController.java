package com.ssafy.springserver.controller;
import com.ssafy.springserver.dto.ChildRequest;
import com.ssafy.springserver.dto.ChildResponse;
import com.ssafy.springserver.service.ChildService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
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

    @PutMapping("/{childId}")
    public ResponseEntity<ChildResponse> updateChild(@PathVariable UUID childId, @RequestBody ChildRequest child) {
        return ResponseEntity.ok(childService.updateChild(childId, child));
    }
}
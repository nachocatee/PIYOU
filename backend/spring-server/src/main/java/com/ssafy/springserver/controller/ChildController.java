package com.ssafy.springserver.controller;
import com.ssafy.springserver.dto.ChildRequest;
import com.ssafy.springserver.dto.ChildResponse;
import com.ssafy.springserver.dto.CollectedResponse;
import com.ssafy.springserver.service.ChildService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
     * 피유 도감 보기
     * 사용자가 이제까지 얻은 피유리스트 조회
     *
     * @param childId 아이 id
     * @return 피유리스트
     */
    @GetMapping("piyou/{childId}")
    public ResponseEntity<List<CollectedResponse>> getPiyouList(@PathVariable UUID childId) {
        return ResponseEntity.ok(childService.getPiyouList(childId));
    }

    /**
     * 피유 도감 등록
     * 사용자가 피유를 얻었을 때 피유 도감에 등록
     *
     * @param childId 아이 id
     * @param piyouId 피유 id
     * @return 등록 결과
     */
    @PostMapping("piyou/{childId}/{piyouId}")
    public ResponseEntity<CollectedResponse> createPiyou(@PathVariable UUID childId, @PathVariable Long piyouId) {
        return ResponseEntity.ok(childService.createPiyou(childId, piyouId));
    }
}
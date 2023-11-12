package com.b106_402jeoung.PIYOU.controller;

import com.b106_402jeoung.PIYOU.dto.CollectedResponse;
import com.b106_402jeoung.PIYOU.dto.StatusResponse;
import com.b106_402jeoung.PIYOU.service.PiyouService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/piyou")
public class PiyouController {
    private final PiyouService piyouService;

    /**
     * 피유 도감 보기
     * 사용자가 이제까지 얻은 피유리스트 조회
     *
     * @param childId 아이 id
     * @return 피유리스트
     */
    @GetMapping("/{childId}")
    public ResponseEntity<List<CollectedResponse>> getPiyouList(@PathVariable UUID childId) {
        return ResponseEntity.ok(piyouService.getPiyouList(childId));
    }

    /**
     * 피유 도감 등록
     * 사용자가 피유를 얻었을 때 피유 도감에 등록
     *
     * @param childId   아이 id
     * @param piyouName 피유 id
     * @return 등록 결과
     */
    @PostMapping("/{childId}/{piyouName}")
    public ResponseEntity<CollectedResponse> createPiyou(@PathVariable UUID childId, @PathVariable String piyouName) {
        return ResponseEntity.ok(piyouService.createPiyou(childId, piyouName));
    }
}

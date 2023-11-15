package com.b106_402jeoung.PIYOU.controller;

import com.b106_402jeoung.PIYOU.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/token")
public class TokenController {
    private final TokenService tokenService;

    @PutMapping("/{childId}")
    public String setToken(@PathVariable UUID childId, @RequestBody Map<String, String> token) {
        tokenService.setToken(childId, token);
        return "Token이 저장되었습니다.";
    }
}

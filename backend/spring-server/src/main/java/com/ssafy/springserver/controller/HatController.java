package com.ssafy.springserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hat")
public class HatController {
    @GetMapping(value = "/getMethodName")
    public ResponseEntity<?> getHat() {
        return ResponseEntity.ok();
    }
}

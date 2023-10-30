package com.ssafy.springserver.controller;

import com.ssafy.springserver.service.PushService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/push")
public class PushController {
    private final PushService pushService;
    @GetMapping("/subscribe")
    public SseEmitter subscribe() {
        SseEmitter emitter = new SseEmitter();
        pushService.addEmitter(emitter);

        emitter.onTimeout(() -> pushService.removeEmitter(emitter));
        emitter.onCompletion(() -> pushService.removeEmitter(emitter));

        return emitter;
    }
}

package com.ssafy.springserver.service;

import com.ssafy.springserver.entity.Child;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.concurrent.CopyOnWriteArrayList;

@Service
@RequiredArgsConstructor
public class PushService {
    private final CopyOnWriteArrayList<SseEmitter> emitters = new CopyOnWriteArrayList<>();
    public void addEmitter(SseEmitter emitter) {
        emitters.add(emitter);
    }

    public void removeEmitter(SseEmitter emitter) {
        emitters.remove(emitter);
    }

    public void alertStarved(Child child) {
        if (child.getStarved() > 5) {
            for (SseEmitter emitter : emitters) {
                try {
                    emitter.send(child);
                } catch (Exception e) {
                    emitters.remove(emitter);
                }
            }
        }
    }
}

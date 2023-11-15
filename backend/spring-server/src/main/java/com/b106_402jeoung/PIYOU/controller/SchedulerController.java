package com.b106_402jeoung.PIYOU.controller;

import com.b106_402jeoung.PIYOU.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/scheduler")
public class SchedulerController {
    private final SchedulerService schedulerService;

    @Scheduled(cron = "0 0 1 * * *")
    @PutMapping("/isMeal")
    public void updateChildIsMeal() {
        schedulerService.updateChildIsMeal();
    }

    /**
     * isMeal이 false인 아이의 경험치를 4 감소, scheduler를 사용해서 매일 00:00:00에 실행
     */
    @Scheduled(cron = "0 0 0 * * *")
    @PutMapping("/exp")
    public void updateChildExp() {
        schedulerService.updateChildExp();
    }
}

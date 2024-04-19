package com.konasl.livescore.controller;

import com.konasl.livescore.service.DineshService;
import com.konasl.livescore.service.KeerthanaService;
import com.konasl.livescore.service.impl.DineshServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/dinesh")
@RequiredArgsConstructor
public class DineshScoreController {

    private final DineshService dineshService;

    @GetMapping(value = "/heartbeat")
    public String findDineshHeartBeat() {
        return "Hi, Hello !!!";
    }

    @GetMapping(value = "/heartbeat/service")
    public String findDineshHeartBeatService() {
        return dineshService.getHeartBeatFromService();
    }
}



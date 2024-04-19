package com.konasl.livescore.controller;

import com.konasl.livescore.entity.Student;
import com.konasl.livescore.service.DineshService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<Student> findDineshHeartBeatService() {
        return dineshService.getHeartBeatFromService();
    }
}



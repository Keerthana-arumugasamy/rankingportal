package com.konasl.livescore.controller;

import com.konasl.livescore.dto.LiveScoreRequest;
import com.konasl.livescore.dto.LiveScoreResponse;
import com.konasl.livescore.entity.Faculty;
import com.konasl.livescore.service.KeerthanaService;
import com.konasl.livescore.service.LiveScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/keerthana")
@RequiredArgsConstructor
public class KeerthanaScoreController {

    private final KeerthanaService keerthanaService;

    @GetMapping(value = "/heartbeat")
    public String findKeerthanaHeartBeat() {
        return "Hi Dinesh Bava Im here";
    }
    @GetMapping(value = "/heartbeat/service")
    public List<Faculty> findKeerthanaHeartBeatFromService() {
        return keerthanaService.getHeartbeatFromService();

    }
}

package com.konasl.livescore.controller;

import com.konasl.livescore.dto.LevelRequest;
import com.konasl.livescore.dto.StackRequest;
import com.konasl.livescore.entity.Level;
import com.konasl.livescore.entity.Stack;
import com.konasl.livescore.service.LevelService;
import com.konasl.livescore.service.StackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/level")
@RequiredArgsConstructor
public class LevelController {

    private final LevelService levelService;

    @GetMapping(value = "/view")
    public String findLevel() {
        return "Level Here!!";
    }

    @GetMapping(value = "/all")
    public List<Level> findKeerthanaHeartBeatFromService() {
        return levelService.getAllLevel();
    }

    @PostMapping(value = "/save", produces = APPLICATION_JSON_VALUE)
    public Level saveLevel(@RequestBody LevelRequest levelRequest) {
        return levelService.saveLevel(levelRequest);
    }
}

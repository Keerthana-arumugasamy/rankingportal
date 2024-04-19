package com.konasl.livescore.controller;

import com.konasl.livescore.dto.StackRequest;
import com.konasl.livescore.entity.Faculty;
import com.konasl.livescore.entity.Stack;
import com.konasl.livescore.service.StackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/stack")
@RequiredArgsConstructor
public class StackController {

    private final StackService stackService;

    @GetMapping(value = "/view")
    public String findStack() {
        return "Stack Here!!";
    }

    @GetMapping(value = "/all")
    public List<Stack> findKeerthanaHeartBeatFromService() {
        return stackService.getAllStack();
    }

    @PostMapping(value = "/save", produces = APPLICATION_JSON_VALUE)
    public Stack saveStack(@RequestBody StackRequest stackRequest) {
        return stackService.saveStack(stackRequest);
    }
}

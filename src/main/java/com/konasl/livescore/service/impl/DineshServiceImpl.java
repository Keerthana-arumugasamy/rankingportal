package com.konasl.livescore.service.impl;

import com.konasl.livescore.service.DineshService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DineshServiceImpl implements DineshService {
    @Override
    public String getHeartBeatFromService() {
        return "HELLO, I'M IN SERVICE";
    }
}

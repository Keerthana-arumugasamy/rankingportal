package com.konasl.livescore.service.impl;

import com.konasl.livescore.service.KeerthanaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KeerthanaServiceImpl implements KeerthanaService {
    @Override
    public String getHeartbeatFromService() {
        return "Hello bava im in service";
    }
}

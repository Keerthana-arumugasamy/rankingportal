package com.konasl.livescore.service.impl;

import com.konasl.livescore.configuration.mapper.MapperRegistry;
import com.konasl.livescore.dto.StackRequest;
import com.konasl.livescore.entity.Stack;
import com.konasl.livescore.repository.StackRepository;
import com.konasl.livescore.service.StackService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StackServiceImpl implements StackService {
    private final StackRepository stackRepository;
    private final MapperRegistry mapperRegistry;
    @Override
    public List<Stack> getAllStack() {
        return stackRepository.findAll();
    }

    @Override
    public Stack saveStack(StackRequest stackRequest) {
        return stackRepository.save(mapperRegistry.getMapper(StackRequest.class, Stack.class).map(stackRequest));
    }
}


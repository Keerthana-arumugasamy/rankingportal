package com.konasl.livescore.service.impl;

import com.konasl.livescore.configuration.mapper.MapperRegistry;
import com.konasl.livescore.dto.LevelRequest;
import com.konasl.livescore.entity.Level;
import com.konasl.livescore.repository.LevelRepository;
import com.konasl.livescore.service.LevelService;
import com.konasl.livescore.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {
    private final LevelRepository levelRepository;
    private final MapperRegistry mapperRegistry;
    @Override
    public List<Level> getAllLevel() {
        return levelRepository.findAll();
    }

    public Level saveLevel(LevelRequest levelRequest) {
       return levelRepository.save(mapperRegistry.getMapper(LevelRequest.class,Level.class).map(levelRequest));
    }
}

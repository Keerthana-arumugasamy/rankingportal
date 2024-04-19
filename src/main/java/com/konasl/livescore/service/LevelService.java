package com.konasl.livescore.service;

import com.konasl.livescore.dto.LevelRequest;
import com.konasl.livescore.entity.Level;

import java.util.List;

public interface LevelService {
    List<Level> getAllLevel();
    Level saveLevel(LevelRequest levelRequest);
}

package com.konasl.livescore.mapper;

import com.konasl.livescore.configuration.mapper.Mapper;
import com.konasl.livescore.configuration.mapper.MapperRegistry;
import com.konasl.livescore.dto.LevelRequest;
import com.konasl.livescore.dto.LevelResponse;
import com.konasl.livescore.dto.StackRequest;
import com.konasl.livescore.dto.StackResponse;
import com.konasl.livescore.entity.Level;
import com.konasl.livescore.entity.Stack;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class LevelMappers {
    private final MapperRegistry mapperRegistry;

    @PostConstruct
    private void registerMappers() {
        mapperRegistry.addMapper(Level.class, LevelResponse.class, leveltoLevelResponseMapper());
        mapperRegistry.addMapper(LevelRequest.class, Level.class, levelRequestTolevelMapper());
    }

    private Mapper<LevelRequest, Level> levelRequestTolevelMapper() {
        return LevelRequest -> Level.builder()
                .level(LevelRequest.getLevel())
                .course(LevelRequest.getCourse())
                .status(LevelRequest.getStatus())
                .student_id(LevelRequest.getStudentId())
                .build();
    }

    private Mapper<Level, LevelResponse> leveltoLevelResponseMapper() {
        return Level -> LevelResponse.builder()
                .level(Level.getLevel())
                .course(Level.getCourse())
                .status(Level.getStatus())
                .studentId(Level.getStudent_id())
                .build();
    }


}

package com.konasl.livescore.mapper;

import com.konasl.livescore.configuration.mapper.Mapper;
import com.konasl.livescore.configuration.mapper.MapperRegistry;
import com.konasl.livescore.dto.StackRequest;
import com.konasl.livescore.dto.StackResponse;
import com.konasl.livescore.dto.StageResponse;
import com.konasl.livescore.entity.Stack;
import com.konasl.livescore.entity.Stage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class StageMappers {
    private final MapperRegistry mapperRegistry;

    @PostConstruct
    private void registerMappers() {
        mapperRegistry.addMapper(Stage.class, StageResponse.class, stageToStageResponseMapper());
    }


    private Mapper<Stage, StageResponse> stageToStageResponseMapper() {
        return stage -> StageResponse.builder()
                .stage(stage.getStage())
                .week(stage.getWeek())
                .studentId(stage.getStudent_id())
                .status(stage.getStatus())
                .build();
    }


}

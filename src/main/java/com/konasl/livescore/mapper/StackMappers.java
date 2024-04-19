package com.konasl.livescore.mapper;

import com.konasl.livescore.configuration.mapper.Mapper;
import com.konasl.livescore.configuration.mapper.MapperRegistry;
import com.konasl.livescore.dto.FacultyRequest;
import com.konasl.livescore.dto.FacultyResponse;
import com.konasl.livescore.dto.StackRequest;
import com.konasl.livescore.dto.StackResponse;
import com.konasl.livescore.entity.Faculty;
import com.konasl.livescore.entity.Stack;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class StackMappers {
    private final MapperRegistry mapperRegistry;

    @PostConstruct
    private void registerMappers() {
        mapperRegistry.addMapper(Stack.class, StackResponse.class, stackToStackResponseMapper());
        mapperRegistry.addMapper(StackRequest.class, Stack.class, stackRequestTostackMapper());
    }

    private Mapper<StackRequest, Stack> stackRequestTostackMapper() {
        return StackRequest -> Stack.builder()
                .description(StackRequest.getDescription())
                .name(StackRequest.getName())
                .build();
    }

    private Mapper<Stack, StackResponse> stackToStackResponseMapper() {
        return Stack -> StackResponse.builder()
                .description(Stack.getDescription())
                .name(Stack.getName())
                .build();
    }


}

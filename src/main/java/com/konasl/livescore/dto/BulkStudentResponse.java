package com.konasl.livescore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BulkStudentResponse {
    private StudentResponse studentResponse;
    private List<LevelResponse> levelResponseArrayList;
    private List<StageResponse> stageResponseArrayList;
}

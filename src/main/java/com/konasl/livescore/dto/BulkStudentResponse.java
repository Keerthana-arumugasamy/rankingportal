package com.konasl.livescore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BulkStudentResponse {
    private StudentResponse studentResponse;
    private ArrayList<LevelResponse> levelResponseList;
}

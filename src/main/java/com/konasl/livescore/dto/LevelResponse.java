package com.konasl.livescore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LevelResponse {
    private Long id;
    private String course;
    private String status;
    private Long level;
    private Long studentId;
}

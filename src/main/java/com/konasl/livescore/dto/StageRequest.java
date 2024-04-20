package com.konasl.livescore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StageRequest {
    private Long stage;
    private String status;
    private Long studentId;
    private Long week;
    private Long id;
}

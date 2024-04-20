package com.konasl.livescore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StudentRequest {
    private Long id;
    private String email;
    private String name;
    private String department;
    private Long marks;
    private Long project;
    private Long stack;
    private String rollno;
}

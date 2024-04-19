package com.konasl.livescore.mapper;

import com.konasl.livescore.configuration.mapper.Mapper;
import com.konasl.livescore.configuration.mapper.MapperRegistry;
import com.konasl.livescore.dto.FacultyResponse;
import com.konasl.livescore.dto.StudentResponse;
import com.konasl.livescore.entity.Faculty;
import com.konasl.livescore.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class FacultyMappers {
    private final MapperRegistry mapperRegistry;

    @PostConstruct
    private void registerMappers() {
        mapperRegistry.addMapper(Faculty.class, FacultyResponse.class, facultyToFacultyResponseMapper());
    }

    private Mapper<Faculty, FacultyResponse> facultyToFacultyResponseMapper() {
        return faculty -> FacultyResponse.builder()
                .id(faculty.getId())
                .name(faculty.getName())
                .department(faculty.getDepartment())
                .email(faculty.getEmail())
                .build();
    }
}

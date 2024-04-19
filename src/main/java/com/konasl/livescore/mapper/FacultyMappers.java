package com.konasl.livescore.mapper;

import com.konasl.livescore.configuration.mapper.Mapper;
import com.konasl.livescore.configuration.mapper.MapperRegistry;
import com.konasl.livescore.dto.FacultyRequest;
import com.konasl.livescore.dto.FacultyResponse;
import com.konasl.livescore.dto.StudentRequest;
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
        mapperRegistry.addMapper(FacultyRequest.class, Faculty.class, facultyRequestTofacultyMapper());
    }

    private Mapper<FacultyRequest, Faculty> facultyRequestTofacultyMapper() {
        return facultyRequest -> Faculty.builder()
                .department(facultyRequest.getDepartment())
                .email(facultyRequest.getEmail())
                .name(facultyRequest.getName())
                .rollno(facultyRequest.getRollno())
                .build();
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

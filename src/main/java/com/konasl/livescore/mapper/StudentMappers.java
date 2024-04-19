package com.konasl.livescore.mapper;

import com.konasl.livescore.configuration.mapper.Mapper;
import com.konasl.livescore.configuration.mapper.MapperRegistry;
import com.konasl.livescore.dto.StudentResponse;
import com.konasl.livescore.dto.UserRequest;
import com.konasl.livescore.dto.UserResponse;
import com.konasl.livescore.entity.Student;
import com.konasl.livescore.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class StudentMappers {
    private final MapperRegistry mapperRegistry;

    @PostConstruct
    private void registerMappers() {
        mapperRegistry.addMapper(Student.class, StudentResponse.class, studentToStudentResponseMapper());
    }

    private Mapper<Student, StudentResponse> studentToStudentResponseMapper() {
        return student -> StudentResponse.builder()
                .department(student.getDepartment())
                .marks(student.getMarks())
                .name(student.getName())
                .stack(student.getStack())
                .project(student.getProject())
                .email(student.getEmail())
                .id(student.getId())
                .rollno(student.getRollno())
                .build();
    }
}

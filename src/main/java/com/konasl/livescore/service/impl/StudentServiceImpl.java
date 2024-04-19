package com.konasl.livescore.service.impl;

import com.konasl.livescore.configuration.mapper.MapperRegistry;
import com.konasl.livescore.dto.StudentRequest;
import com.konasl.livescore.entity.Student;
import com.konasl.livescore.repository.StudentRepository;
import com.konasl.livescore.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final MapperRegistry mapperRegistry;
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(StudentRequest studentRequest) {
       return studentRepository.save(mapperRegistry.getMapper(StudentRequest.class,Student.class).map(studentRequest));
    }
}

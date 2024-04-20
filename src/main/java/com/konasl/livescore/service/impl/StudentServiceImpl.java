package com.konasl.livescore.service.impl;

import com.konasl.livescore.configuration.mapper.MapperRegistry;
import com.konasl.livescore.dto.*;
import com.konasl.livescore.entity.Level;
import com.konasl.livescore.entity.Stage;
import com.konasl.livescore.entity.Student;
import com.konasl.livescore.repository.LevelRepository;
import com.konasl.livescore.repository.StageRepository;
import com.konasl.livescore.repository.StudentRepository;
import com.konasl.livescore.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StageRepository stageRepository;
    private final LevelRepository levelRepository;
    private final MapperRegistry mapperRegistry;
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(StudentRequest studentRequest) {
       return studentRepository.save(mapperRegistry.getMapper(StudentRequest.class,Student.class).map(studentRequest));
    }

    @Override
    public Student updateStudent(StudentRequest studentRequest, Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if(student == null) return null;
        student.setMarks(studentRequest.getMarks());
        student.setProject(studentRequest.getProject());
        student.setStack(studentRequest.getStack());
        return studentRepository.save(student);
    }

    @Override
    public BulkStudentResponse getStudentDetails(StudentRequest studentRequest) {
        Student student = studentRepository.findById(studentRequest.getId()).orElse(null);
        if(student == null) return null;
        List<Stage> stagelist = stageRepository.findAllByStudent_id(student.getId());
        List<Level> levelList = levelRepository.findAllByStudent_id(student.getId());

        return BulkStudentResponse.builder()
                .studentResponse(mapperRegistry.getMapper(Student.class, StudentResponse.class).map(student))
                .levelList(levelList.stream().map(level -> mapperRegistry.getMapper(Level.class, LevelResponse.class).map(level)).collect(Collectors.toList()))
                .stageList(stagelist.stream().map(stage -> mapperRegistry.getMapper(Stage.class,StageResponse.class).map(stage)).collect(Collectors.toList()))
                .build();
    }
}

package com.konasl.livescore.service.impl;

import com.konasl.livescore.configuration.mapper.MapperRegistry;
import com.konasl.livescore.dto.FacultyRequest;
import com.konasl.livescore.entity.Faculty;
import com.konasl.livescore.entity.Student;
import com.konasl.livescore.repository.FacultyRepository;
import com.konasl.livescore.service.FacultyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository facultyRepository;
    private final MapperRegistry mapperRegistry;
    @Override
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty saveFaculty(FacultyRequest facultyRequest) {
        return facultyRepository.save(mapperRegistry.getMapper(FacultyRequest.class, Faculty.class).map(facultyRequest));
    }

    @Override
    public Faculty updateFaculty(FacultyRequest facultyRequest, Long facultyId) {
        Faculty faculty = facultyRepository.findById(facultyId).orElse(null);
        if(faculty == null) return null;
        faculty.setDepartment(facultyRequest.getDepartment());
        faculty.setEmail(facultyRequest.getEmail());
        faculty.setRollno(facultyRequest.getRollno());
        return facultyRepository.save(faculty);
    }
}


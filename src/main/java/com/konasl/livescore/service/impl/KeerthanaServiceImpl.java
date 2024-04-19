package com.konasl.livescore.service.impl;

import com.konasl.livescore.dto.FacultyResponse;
import com.konasl.livescore.entity.Faculty;
import com.konasl.livescore.entity.Student;
import com.konasl.livescore.repository.FacultyRepository;
import com.konasl.livescore.repository.StudentRepository;
import com.konasl.livescore.service.DineshService;
import com.konasl.livescore.service.KeerthanaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class KeerthanaServiceImpl implements KeerthanaService {
    private final FacultyRepository facultyRepository;
    @Override
    public List<Faculty> getHeartbeatFromService() {
        return facultyRepository.findAll();
    }
}

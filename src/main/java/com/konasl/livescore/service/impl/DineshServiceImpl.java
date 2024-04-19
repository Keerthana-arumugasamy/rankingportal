package com.konasl.livescore.service.impl;

import com.konasl.livescore.entity.Student;
import com.konasl.livescore.repository.StudentRepository;
import com.konasl.livescore.service.DineshService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DineshServiceImpl implements DineshService {
    private final StudentRepository studentRepository;
    @Override
    public List<Student> getHeartBeatFromService() {
        return studentRepository.findAll();
    }
}

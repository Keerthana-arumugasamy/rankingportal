package com.konasl.livescore.service.impl;

import com.konasl.livescore.configuration.mapper.MapperRegistry;
import com.konasl.livescore.dto.*;
import com.konasl.livescore.entity.Admin;
import com.konasl.livescore.entity.Level;
import com.konasl.livescore.entity.Stage;
import com.konasl.livescore.entity.Student;
import com.konasl.livescore.repository.AdminRepository;
import com.konasl.livescore.repository.LevelRepository;
import com.konasl.livescore.repository.StageRepository;
import com.konasl.livescore.repository.StudentRepository;
import com.konasl.livescore.service.AdminService;
import com.konasl.livescore.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final MapperRegistry mapperRegistry;

    @Override
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public Admin saveAdmin(AdminRequest adminRequest) {
        return adminRepository.save(mapperRegistry.getMapper(AdminRequest.class,Admin.class).map(adminRequest));
    }
}

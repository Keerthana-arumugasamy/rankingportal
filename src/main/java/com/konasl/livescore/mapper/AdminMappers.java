package com.konasl.livescore.mapper;

import com.konasl.livescore.configuration.mapper.Mapper;
import com.konasl.livescore.configuration.mapper.MapperRegistry;
import com.konasl.livescore.dto.AdminRequest;
import com.konasl.livescore.dto.AdminResponse;
import com.konasl.livescore.dto.StudentRequest;
import com.konasl.livescore.dto.StudentResponse;
import com.konasl.livescore.entity.Admin;
import com.konasl.livescore.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class AdminMappers {
    private final MapperRegistry mapperRegistry;

    @PostConstruct
    private void registerMappers() {
        mapperRegistry.addMapper(Admin.class, AdminResponse.class, adminToAdminResponseMapper());
        mapperRegistry.addMapper(AdminRequest.class, Admin.class, adminRequestToAdminMapper());
    }

    private Mapper<AdminRequest, Admin> adminRequestToAdminMapper() {
        return AdminRequest -> Admin.builder()
                .email(AdminRequest.getEmail())
                .name(AdminRequest.getName())
                .build();
    }

    private Mapper<Admin, AdminResponse> adminToAdminResponseMapper() {
        return Admin -> AdminResponse.builder()
                .email(Admin.getEmail())
                .name(Admin.getName())
                .build();
    }
}

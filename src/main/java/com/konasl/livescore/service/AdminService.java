package com.konasl.livescore.service;

import com.konasl.livescore.dto.AdminRequest;
import com.konasl.livescore.entity.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAllAdmin();
    Admin saveAdmin(AdminRequest adminRequest);
}

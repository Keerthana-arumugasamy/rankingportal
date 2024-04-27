package com.konasl.livescore.controller;

import com.konasl.livescore.dto.AdminRequest;
import com.konasl.livescore.entity.Admin;
import com.konasl.livescore.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping(value = "/heartbeat")
    public String findAdminHeartbeat() {
        return "Hi, Admin Here !!!";
    }

    @GetMapping(value="/all")
    public List<Admin> findAllAdmin() {
        return adminService.getAllAdmin();
    }

    @PostMapping(value = "/save", produces = APPLICATION_JSON_VALUE)
    public Admin saveAdmin(@RequestBody AdminRequest adminRequest) {
        return adminService.saveAdmin(adminRequest);
    }

}



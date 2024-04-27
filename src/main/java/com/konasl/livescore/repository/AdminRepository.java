package com.konasl.livescore.repository;

import com.konasl.livescore.entity.Admin;
import com.konasl.livescore.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Override
    List<Admin> findAll();
}

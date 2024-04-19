package com.konasl.livescore.repository;

import com.konasl.livescore.entity.Faculty;
import com.konasl.livescore.entity.Stack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StackRepository extends JpaRepository<Stack, Long> {
    @Override
    List<Stack> findAll();
}

package com.konasl.livescore.repository;

import com.konasl.livescore.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {
    @Override
    List<Stage> findAll();
}

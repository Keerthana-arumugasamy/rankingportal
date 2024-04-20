package com.konasl.livescore.repository;

import com.konasl.livescore.entity.Level;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
    @Override
    List<Level> findAll();
    @Query("SELECT l FROM Level l WHERE l.student_id = :studentId")
    List<Level> findAllByStudent_id(Long studentId);
}

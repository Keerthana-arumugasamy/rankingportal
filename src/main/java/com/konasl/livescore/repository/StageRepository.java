package com.konasl.livescore.repository;

import com.konasl.livescore.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {
    @Override
    List<Stage> findAll();
    @Query("SELECT s FROM Stage s WHERE s.student_id = :studentId")
    List<Stage> findAllByStudent_id(Long studentId);
}

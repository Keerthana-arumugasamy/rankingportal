package com.konasl.livescore.service;

import com.konasl.livescore.dto.FacultyRequest;
import com.konasl.livescore.entity.Faculty;

import java.util.List;

public interface FacultyService {
    List<Faculty> getAllFaculty();
    Faculty saveFaculty(FacultyRequest facultyRequest);
    Faculty updateFaculty(FacultyRequest facultyRequest, Long facultyId);
}

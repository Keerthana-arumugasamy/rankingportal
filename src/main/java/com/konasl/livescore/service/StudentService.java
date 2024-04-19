package com.konasl.livescore.service;

import com.konasl.livescore.dto.StudentRequest;
import com.konasl.livescore.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(StudentRequest studentRequest);
}

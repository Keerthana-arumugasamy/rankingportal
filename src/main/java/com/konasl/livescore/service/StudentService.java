package com.konasl.livescore.service;

import com.konasl.livescore.dto.BulkStudentResponse;
import com.konasl.livescore.dto.StudentRequest;
import com.konasl.livescore.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(StudentRequest studentRequest);
    Student updateStudent(StudentRequest studentRequest, Long studentId);
    BulkStudentResponse getStudentDetails(StudentRequest studentRequest);
}

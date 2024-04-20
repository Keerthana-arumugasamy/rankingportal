package com.konasl.livescore.controller;

import com.konasl.livescore.dto.BulkStudentResponse;
import com.konasl.livescore.dto.LiveScoreRequest;
import com.konasl.livescore.dto.LiveScoreResponse;
import com.konasl.livescore.dto.StudentRequest;
import com.konasl.livescore.entity.Student;
import com.konasl.livescore.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping(value = "/heartbeat")
    public String findStudentHeartbeat() {
        return "Hi, Hello !!!";
    }

    @GetMapping(value = "/all")
    public List<Student> findDineshHeartBeatService() {
        return studentService.getAllStudents();
    }

    @PostMapping(value = "/save", produces = APPLICATION_JSON_VALUE)
    public Student saveStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.saveStudent(studentRequest);
    }

    @PutMapping(value = "/update", produces = APPLICATION_JSON_VALUE)
    public Student updatedStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.updateStudent(studentRequest, studentRequest.getId());
    }

    @PostMapping(value = "/details")
    public BulkStudentResponse getBulkStudentDetails(@RequestBody StudentRequest studentRequest) {
        return studentService.getStudentDetails(studentRequest);
    }
}



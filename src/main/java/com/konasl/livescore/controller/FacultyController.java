package com.konasl.livescore.controller;

import com.konasl.livescore.dto.FacultyRequest;
import com.konasl.livescore.entity.Faculty;
import com.konasl.livescore.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/faculty")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;

    @GetMapping(value = "/heartbeat")
    public String findKeerthanaHeartBeat() {
        return "Hi Dinesh Bava Im here";
    }

    @GetMapping(value = "/all")
    public List<Faculty> findKeerthanaHeartBeatFromService() {
        return facultyService.getAllFaculty();
    }

    @PostMapping(value = "/save", produces = APPLICATION_JSON_VALUE)
    public Faculty saveFaculty(@RequestBody FacultyRequest facultyRequest) {
        return facultyService.saveFaculty(facultyRequest);
    }

    @PutMapping(value = "/update", produces = APPLICATION_JSON_VALUE)
    public Faculty updatedFaculty(@RequestBody FacultyRequest facultyRequest) {
        return facultyService.updateFaculty(facultyRequest, facultyRequest.getId());
    }
}

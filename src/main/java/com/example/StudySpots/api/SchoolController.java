package com.example.StudySpots.api;


import com.example.StudySpots.model.School;
import com.example.StudySpots.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/school")
@RestController
@CrossOrigin("*")
public class SchoolController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping
    public void insertSchool(@NonNull @RequestBody School school) {
        schoolService.insertSchool(school);
    }

    @GetMapping
    public List<School> selectAllSchools() {
        return schoolService.selectAllSchools();
    }

    @GetMapping(path = "{id}")
    public School selectSchoolById(@PathVariable("id") UUID id) {
        return schoolService.selectSchoolById(id)
                .orElse(null);
    }

    @PutMapping(path = "{id}")
    public void updateSchoolById(@PathVariable("id") UUID id, @RequestBody School school) {
        schoolService.updateSchoolById(id, school);
    }

}

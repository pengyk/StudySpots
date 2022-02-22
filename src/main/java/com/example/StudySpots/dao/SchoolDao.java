package com.example.StudySpots.dao;

import com.example.StudySpots.model.School;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SchoolDao {

    int insertSchool(UUID id, School school);


    default int insertSchool(School school) {
        UUID id = UUID.randomUUID();
        return insertSchool(id, school);
    }

    List<School> selectAllSchools();

    int updateSchoolById(UUID id, School school);

    Optional<School> selectSchoolById(UUID id);

    int deleteSchoolById(UUID id);
}

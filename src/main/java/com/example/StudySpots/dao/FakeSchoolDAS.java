package com.example.StudySpots.dao;

import com.example.StudySpots.model.School;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeSchoolDAS implements SchoolDao{

    private static List<School> DB = new ArrayList<>();
    @Override
    public int insertSchool(UUID id, School school) {
        DB.add(new School(id, school.getSchoolName(), school.getCity(), school.getProvince()));
        return 1;
    }

    @Override
    public int insertSchool(School school) {
        return SchoolDao.super.insertSchool(school);
    }

    @Override
    public List<School> selectAllSchools() {
        return DB;
    }

    @Override
    public int updateSchoolById(UUID id, School school) {
        return 0;
    }

    @Override
    public Optional<School> selectSchoolById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteSchoolById(UUID id) {
        return 0;
    }

}

package com.example.StudySpots.service;

import com.example.StudySpots.dao.SchoolDao;
import com.example.StudySpots.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SchoolService {

    private final SchoolDao schoolDao;

    @Autowired
    public SchoolService(@Qualifier("postgres") SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    public int insertSchool(School school) {
        return schoolDao.insertSchool(school);
    }

    public List<School> selectAllSchools() {
        return schoolDao.selectAllSchools();
    }

    public Optional<School> selectSchoolById(UUID id) {
        return schoolDao.selectSchoolById(id);
    }

    public int updateSchoolById(UUID id, School school) { return schoolDao.updateSchoolById(id, school); }


}

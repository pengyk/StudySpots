package com.example.StudySpots.dao;

import com.example.StudySpots.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository("postgres")
public class SchoolDataAccessService implements SchoolDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SchoolDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertSchool(UUID id, School school) {
        final String sql = "INSERT INTO schools(id, schoolName, city, province) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, id, school.getSchoolName(), school.getCity(), school.getProvince());
    }

    @Override
    public List<School> selectAllSchools() {
        final String sql = "SELECT id, schoolName, city, province FROM schools";
        return jdbcTemplate.query(sql, (resultSet, i) -> new School(
                UUID.fromString(resultSet.getString("id")),
                resultSet.getString("schoolName"),
                resultSet.getString("city"),
                resultSet.getString("province")));
    }

    @Override
    public int updateSchoolById(UUID id, School school) {
        final String sql = "UPDATE schools SET schoolName = ?, city = ?, province = ? WHERE id = ?";
        return jdbcTemplate.update(sql, school.getSchoolName(), school.getCity(), school.getProvince(), id);
    }

    @Override
    public Optional<School> selectSchoolById(UUID id) {
        final String sql = "SELECT id, schoolName, city, province FROM schools WHERE id = ?";
        List<School> schools = jdbcTemplate.query(
                sql,
                (resultSet, i) -> new School(
                        UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("schoolName"),
                        resultSet.getString("city"),
                        resultSet.getString("province")), new Object[] { id });
        if (schools == null || schools.size() == 0) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(schools.get(0));
        }
    }

    @Override
    public int deleteSchoolById(UUID id) {
        return 0;
    }
}

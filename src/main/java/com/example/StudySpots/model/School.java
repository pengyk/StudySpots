package com.example.StudySpots.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class School {

    private final UUID id;
    private final String schoolName;
    private final String city;
    private final String province;

    public School(@JsonProperty("id") UUID id,
                  @JsonProperty("schoolName") String schoolName,
                  @JsonProperty("city") String city,
                  @JsonProperty("province") String province) {
        this.id = id;
        this.schoolName = schoolName;
        this.city = city;
        this.province = province;
    }

    public UUID getId() {
        return id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }


}

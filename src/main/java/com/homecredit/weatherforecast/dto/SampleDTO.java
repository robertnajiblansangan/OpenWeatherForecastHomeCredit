package com.homecredit.weatherforecast.dto;

public class SampleDTO {
    private String name;
    private String age;

    public SampleDTO(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}

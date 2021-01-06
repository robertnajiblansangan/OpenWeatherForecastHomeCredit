package com.homecredit.weatherforecast.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name ="WeatherLog")
public class WeatherForecastLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO  ,generator = "seq")
    private Long id;

    @Column(name ="responseId")
    private String responseId;
    @Column(name ="location")
    private String location;
    @Column(name ="actualWeather")
    private String actualWeather;
    @Column(name ="temperature")
    private String temperature;
    @Column(name = "dtimeInserted")
    @CreationTimestamp
    private LocalDateTime dtimeInserted;

    public WeatherForecastLog(){
        super();
    }

    public WeatherForecastLog(String responseId, String location, String actualWeather, String temperature) {
        this.responseId = responseId;
        this.location = location;
        this.actualWeather = actualWeather;
        this.temperature = temperature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getActualWeather() {
        return actualWeather;
    }

    public void setActualWeather(String actualWeather) {
        this.actualWeather = actualWeather;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public LocalDateTime getDtimeInserted() {
        return dtimeInserted;
    }

    public void setDtimeInserted(LocalDateTime dtimeInserted) {
        this.dtimeInserted = dtimeInserted;
    }
}

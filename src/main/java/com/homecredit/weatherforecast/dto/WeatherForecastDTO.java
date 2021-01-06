package com.homecredit.weatherforecast.dto;

import com.homecredit.weatherforecast.openWeather.Weather;

import java.util.List;

public class WeatherForecastDTO {
    private String location;
    private List<Weather> actualWeather;
    private Double temperature;
    private String id;

    public WeatherForecastDTO(String location, List<Weather> actualWeather, Double temperature, String id) {
        this.location = location;
        this.actualWeather = actualWeather;
        this.temperature = temperature;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public List<Weather> getActualWeather() {
        return actualWeather;
    }

    public Double getTemperature() {
        return temperature;
    }
}

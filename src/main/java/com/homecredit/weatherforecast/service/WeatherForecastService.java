package com.homecredit.weatherforecast.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.homecredit.weatherforecast.dto.WeatherForecastDTO;
import com.homecredit.weatherforecast.entity.WeatherForecastLog;
import com.homecredit.weatherforecast.repository.WeatherForecastLogRepository;
import com.homecredit.weatherforecast.rest.service.RestAPIService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WeatherForecastService {

    @Autowired
    RestAPIService restAPIService;

    @Autowired
    WeatherForecastLogRepository weatherForecastLogRepository;

    public List<WeatherForecastDTO> getWeatherForecast() throws JsonProcessingException {

        List<WeatherForecastDTO> weatherForecastDTOList = new ArrayList<>();
        weatherForecastDTOList.add(restAPIService.getOpenWeatherMapAPI("London"));
        weatherForecastDTOList.add(restAPIService.getOpenWeatherMapAPI("Prague"));
        weatherForecastDTOList.add(restAPIService.getOpenWeatherMapAPI("San Francisco"));

        return weatherForecastDTOList;
    }

    public void addLog(List<WeatherForecastDTO> weatherForecast) {
        List<WeatherForecastLog> weatherLog = weatherForecast.stream().map(
                a -> new WeatherForecastLog(a.getId(),
                        a.getLocation(),
                        Objects.requireNonNull(a.getActualWeather().stream().findAny().orElse(null)).description,
                        a.getTemperature().toString())).collect(Collectors.toList());


        weatherForecastLogRepository.saveAll(weatherLog);

        long count = weatherForecastLogRepository.count();

        while (count > 5){
            weatherForecastLogRepository.delete(weatherForecastLogRepository.findFirstByOrderByDtimeInsertedAsc());
            count = weatherForecastLogRepository.count();
        }
    }

    public List<WeatherForecastLog> findAllLogs(){
        return weatherForecastLogRepository.findAll();
    }
}

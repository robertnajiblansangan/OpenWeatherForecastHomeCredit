package com.homecredit.weatherforecast.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.homecredit.weatherforecast.dto.WeatherForecastDTO;
import com.homecredit.weatherforecast.entity.WeatherForecastLog;
import com.homecredit.weatherforecast.service.WeatherForecastService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/weatherForecast")
public class WeatherForecastController {

    @Autowired
    WeatherForecastService weatherForecastService;

    @GetMapping(path = "/getWeatherForecast", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WeatherForecastDTO>> getWeatherForecast() throws JsonProcessingException {
        return new ResponseEntity<>(weatherForecastService.getWeatherForecast(), HttpStatus.OK);
    }

    @PostMapping(path = "/weatherForecastLog", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity addLog(@RequestBody List<WeatherForecastDTO> weatherForecast) {
        weatherForecastService.addLog(weatherForecast);

        return new HttpEntity(HttpStatus.CREATED);
    }

    @GetMapping(path = "/getAllLogs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WeatherForecastLog>> finAllLogs() {
        return new ResponseEntity<>(weatherForecastService.findAllLogs(), HttpStatus.OK);
    }

}

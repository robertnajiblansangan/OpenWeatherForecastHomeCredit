package com.homecredit.weatherforecast.rest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.homecredit.weatherforecast.dto.WeatherForecastDTO;
import com.homecredit.weatherforecast.openWeather.OpenWeather;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

import static com.homecredit.weatherforecast.utils.CONSTANTS.APPID;
import static com.homecredit.weatherforecast.utils.CONSTANTS.OPEN_WEATHER_MAP_API;

@Service
@AllArgsConstructor
public class RestAPIService {

    @Autowired
    RestTemplate restTemplate;

    public WeatherForecastDTO getOpenWeatherMapAPI (String location)
            throws JsonProcessingException {

    try{
        if (location.isEmpty()){
                return null;
        }

        ResponseEntity<OpenWeather> openWeatherResponseEntity=  restTemplate.getForEntity(OPEN_WEATHER_MAP_API
                .concat(location).concat(APPID), OpenWeather.class);

        return new WeatherForecastDTO(Objects.requireNonNull(openWeatherResponseEntity.getBody()).name,
                Objects.requireNonNull(openWeatherResponseEntity.getBody()).weather,
                Objects.requireNonNull(openWeatherResponseEntity.getBody()).main.temp,
                Objects.requireNonNull(openWeatherResponseEntity.getBody()).id);

        }catch(HttpClientErrorException e){
            return null;
        }
    }

}

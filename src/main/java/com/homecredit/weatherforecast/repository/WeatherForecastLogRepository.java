package com.homecredit.weatherforecast.repository;

import com.homecredit.weatherforecast.entity.WeatherForecastLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherForecastLogRepository extends JpaRepository<WeatherForecastLog, Long> {
    WeatherForecastLog findFirstByOrderByDtimeInsertedAsc();

    }



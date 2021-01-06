package com.homecredit.weatherforecast.openWeather;

import java.math.BigInteger;
import java.util.List;

public class OpenWeather {
    public Coord coord;
    public List<Weather> weather;
    public String base;
    public Main main;
    public BigInteger visibility;
    public Wind wind;
    public Clouds clouds;
    public BigInteger dt;
    public Sys sys;
    public String timezone;
    public String id;
    public String name;
    public Integer cod;
}

package com.tabardel.weather.services.models;

import java.util.Date;
import java.util.List;

/**
 * Created by TABARDEL_Remy on 08/12/2016.
 */

public class Forecast implements Comparable<Forecast> {
    public final Date date;
    public final Temperature temperature;
    public final double pressure;
    public final int humidity;
    public final List<Weather> weathers;
    public final double speed;
    public final int deg;
    public final int clouds;
    public final double rain;

    public Forecast(Date date,
                    Temperature temperature,
                    double pressure,
                    int humidity,
                    List<Weather> weathers,
                    double speed,
                    int deg,
                    int clouds,
                    double rain) {
        this.date = date;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.weathers = weathers;
        this.speed = speed;
        this.deg = deg;
        this.clouds = clouds;
        this.rain = rain;
    }

    @Override public int compareTo(Forecast another) {
        return this.date.compareTo(another.date);
    }
}

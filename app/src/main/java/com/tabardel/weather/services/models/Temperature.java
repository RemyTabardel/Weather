package com.tabardel.weather.services.models;

/**
 * Created by TABARDEL_Remy on 08/12/2016.
 */

public class Temperature {
    public final double day;
    public final double min;
    public final double max;
    public final double night;
    public final double eve;
    public final double morn;

    public Temperature(double day,
                       double min,
                       double max,
                       double night,
                       double eve,
                       double morn) {
        this.day = day;
        this.min = min;
        this.max = max;
        this.night = night;
        this.eve = eve;
        this.morn = morn;
    }
}

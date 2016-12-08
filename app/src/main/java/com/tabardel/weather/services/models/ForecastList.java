package com.tabardel.weather.services.models;

import java.util.List;

/**
 * Created by TABARDEL_Remy on 08/12/2016.
 */

public class ForecastList {
    public final City city;
    public final List<Forecast> forecasts;

    public ForecastList(City city, List<Forecast> forecasts) {
        this.city = city;
        this.forecasts = forecasts;
    }
}

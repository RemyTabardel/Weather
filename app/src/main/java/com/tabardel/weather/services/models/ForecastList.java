package com.tabardel.weather.services.models;

import java.util.List;

/**
 * Created by TABARDEL_Remy on 08/12/2016.
 */

public class ForecastList {
    public final List<Forecast> forecasts;

    public ForecastList(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }
}

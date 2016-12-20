package com.tabardel.weather.services.network;

import com.tabardel.weather.services.models.ForecastList;

import rx.Observable;

/**
 * Created by TABARDEL_Remy on 09/12/2016.
 */

public interface OpenWeatherApi {
    ForecastList getForecastList(String appid);
}

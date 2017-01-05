package com.tabardel.weather.services.network.retrofit.calls;

import com.tabardel.weather.services.models.ForecastList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by TABARDEL_Remy on 17/12/2016.
 */

public interface OpenWeatherCalls {
    @GET("data/2.5/forecast/daily?q=Paris&units=metric&cnt=5")
    Observable<ForecastList> getForecastFive(@Query("appid") String appid,
                                             @Query("lang") String language);
}

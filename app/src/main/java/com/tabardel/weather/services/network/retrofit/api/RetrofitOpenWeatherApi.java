package com.tabardel.weather.services.network.retrofit.api;

import com.tabardel.weather.services.models.ForecastList;
import com.tabardel.weather.services.network.OpenWeatherApi;
import com.tabardel.weather.services.network.retrofit.ConverterFactory;
import com.tabardel.weather.services.network.retrofit.calls.OpenWeatherCalls;
import com.tabardel.weather.services.network.retrofit.converters.ForecastListConverter;

import okhttp3.OkHttpClient;
import retrofit2.Converter;

/**
 * Created by TABARDEL_Remy on 17/12/2016.
 */

public class RetrofitOpenWeatherApi extends AbstractRetrofitApi<OpenWeatherCalls> implements OpenWeatherApi {
    public RetrofitOpenWeatherApi(String baseUrl, OkHttpClient okHttpClient) {
        super(baseUrl, okHttpClient, OpenWeatherCalls.class);
    }

    @Override public ForecastList getForecastList(String appid) {
        return execute(getCalls().getForecastFive(appid));
    }

    @Override
    public Converter.Factory getConverterFactory() {
        ConverterFactory converterFactory = new ConverterFactory();
        converterFactory.addConverter(new ForecastListConverter());

        return converterFactory;
    }
}

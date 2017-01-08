package com.tabardel.weather.core.presenters;

import android.support.annotation.NonNull;

import com.tabardel.weather.MyApplication;
import com.tabardel.weather.services.models.Forecast;
import com.tabardel.weather.services.models.ForecastList;
import com.tabardel.weather.services.network.api.OpenWeatherApi;
import com.tabardel.weather.ui.views.WeatherView;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by TABARDEL_Remy on 17/12/2016.
 */

public class WeatherPresenter implements BasePresenter {

    @Inject OpenWeatherApi openWeatherApi;
    private WeatherView mWeatherView;

    public WeatherPresenter(WeatherView weatherView) {
        MyApplication.component.inject(this);
        this.mWeatherView = weatherView;
    }

    public void loadForecastList(@NonNull String appid, @NonNull String language) {
        openWeatherApi.getForecastList(appid, language)
                .map(l -> sortListForecast(l))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Forecast>>() {
                    @Override public void onCompleted() {
                    }

                    @Override public void onError(Throwable e) {
                        mWeatherView.errorRecoveringList();
                    }

                    @Override public void onNext(List<Forecast> list) {
                        mWeatherView.setListContent(list);
                    }
                });
    }

    private List<Forecast> sortListForecast(ForecastList forecastList) {
        Collections.sort(forecastList.forecasts);
        return forecastList.forecasts;
    }
}

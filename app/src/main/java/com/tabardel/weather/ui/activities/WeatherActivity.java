package com.tabardel.weather.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.tabardel.weather.R;
import com.tabardel.weather.core.presenters.WeatherPresenter;
import com.tabardel.weather.services.models.Forecast;
import com.tabardel.weather.ui.views.WeatherView;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by TABARDEL_Remy on 07/12/2016.
 */

public class WeatherActivity extends AppCompatActivity implements WeatherView {

    private WeatherPresenter mWeatherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        setPresenter(new WeatherPresenter(this));

        mWeatherPresenter.loadForecastList(getString(R.string.weather_app_id));
    }

    @Override public void setPresenter(WeatherPresenter presenter) {
        mWeatherPresenter = presenter;
    }

    @Override public void setListViewContent(List<Forecast> listForecast) {

    }
}

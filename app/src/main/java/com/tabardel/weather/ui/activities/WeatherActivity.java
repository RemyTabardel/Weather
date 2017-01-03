package com.tabardel.weather.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ViewFlipper;

import com.tabardel.weather.R;
import com.tabardel.weather.core.presenters.WeatherPresenter;
import com.tabardel.weather.services.models.Forecast;
import com.tabardel.weather.ui.views.WeatherView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by TABARDEL_Remy on 07/12/2016.
 */

public class WeatherActivity extends AppCompatActivity implements WeatherView {
    private static final int VIEWSFLIPPER_CHILD_LOADING = 0;
    private static final int VIEWFLIPPER_CHILD_RETRY = 1;
    private static final int VIEWFLIPPER_CHILD_LIST = 2;

    private WeatherPresenter mWeatherPresenter;
    @BindView(R.id.recyclerview) RecyclerView mRecyclerView;
    @BindView(R.id.viewflipper) ViewFlipper mViewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        ButterKnife.bind(this);
        setPresenter(new WeatherPresenter(this));

        //mRecyclerView.setAdapter(new ForecastAdapter(this));

        mWeatherPresenter.loadForecastList(getString(R.string.weather_app_id));
    }

    @OnClick(R.id.button_retry)
    public void onClickButtonRetry() {
        mViewFlipper.setDisplayedChild(VIEWSFLIPPER_CHILD_LOADING);
        mWeatherPresenter.loadForecastList(getString(R.string.weather_app_id));
    }

    @Override public void setPresenter(WeatherPresenter presenter) {
        mWeatherPresenter = presenter;
    }

    @Override public void setListContent(List<Forecast> listForecast) {
        mViewFlipper.setDisplayedChild(VIEWFLIPPER_CHILD_LIST);
    }

    @Override public void errorRecoveringList() {
        mViewFlipper.setDisplayedChild(VIEWFLIPPER_CHILD_RETRY);
    }
}

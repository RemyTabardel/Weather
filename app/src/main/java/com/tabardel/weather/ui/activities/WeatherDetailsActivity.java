package com.tabardel.weather.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tabardel.weather.MyApplication;
import com.tabardel.weather.R;
import com.tabardel.weather.core.presenters.WeatherPresenter;
import com.tabardel.weather.services.images.ImagesLoader;
import com.tabardel.weather.services.models.Forecast;
import com.tabardel.weather.services.models.Weather;

import java.text.SimpleDateFormat;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherDetailsActivity extends AppCompatActivity {
    public static final String EXTRA_FORECAST = "EXTRA_FORECAST";

    @Inject ImagesLoader mImagesLoader;
    @BindView(R.id.linearlayout_weather) LinearLayout mWeatherLinearLayout;

    private Forecast mForecast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_details);

        ButterKnife.bind(this);
        MyApplication.component.inject(this);

        mForecast = getIntent().getParcelableExtra(EXTRA_FORECAST);

        setTitle();
        setWeatherLinearLayout();
    }

    private void setTitle() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE dd MMM yyyy");

        setTitle(simpleDateFormat.format(mForecast.date));
    }

    private void setWeatherLinearLayout() {
        for (Weather weather : mForecast.weathers) {
            View weatherView = LayoutInflater.from(this).inflate(R.layout.item_weather, null);
            ((TextView) ButterKnife.findById(weatherView, R.id.textview_description)).setText(weather.description);

            ImageView imageView = ButterKnife.findById(weatherView, R.id.imageview_icon);
            mImagesLoader.loadWeatherIcon(imageView,weather.icon);

            mWeatherLinearLayout.addView(weatherView);
        }
    }
}

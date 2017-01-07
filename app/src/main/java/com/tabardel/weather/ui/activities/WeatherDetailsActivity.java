package com.tabardel.weather.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tabardel.weather.R;
import com.tabardel.weather.core.presenters.WeatherPresenter;
import com.tabardel.weather.services.models.Forecast;

import java.text.SimpleDateFormat;

import butterknife.ButterKnife;

public class WeatherDetailsActivity extends AppCompatActivity {
    public static final String EXTRA_FORECAST = "EXTRA_FORECAST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_details);

        setTitle();

        ButterKnife.bind(this);
    }

    private void setTitle() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE dd MMM yyyy");
        Forecast forecast = getIntent().getParcelableExtra(EXTRA_FORECAST);

        setTitle(simpleDateFormat.format(forecast.date));
    }
}

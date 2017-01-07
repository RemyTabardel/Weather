package com.tabardel.weather.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tabardel.weather.R;
import com.tabardel.weather.core.presenters.WeatherPresenter;

import butterknife.ButterKnife;

public class WeatherDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_details);

        ButterKnife.bind(this);
    }
}

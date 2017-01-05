package com.tabardel.weather.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ViewFlipper;

import com.tabardel.weather.R;
import com.tabardel.weather.core.presenters.WeatherPresenter;
import com.tabardel.weather.services.models.Forecast;
import com.tabardel.weather.ui.adapters.ForecastAdapter;
import com.tabardel.weather.ui.views.WeatherView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by TABARDEL_Remy on 07/12/2016.
 */

public class WeatherActivity extends AppCompatActivity implements WeatherView {
    private static final String KEY_CURRENT_CHILD = "KEY_CURRENT_CHILD";
    private static final String KEY_LIST_DATA = "KEY_LIST_DATA";
    private static final int VIEWSFLIPPER_CHILD_LOADING = 0;
    private static final int VIEWFLIPPER_CHILD_RETRY = 1;
    private static final int VIEWFLIPPER_CHILD_LIST = 2;

    private WeatherPresenter mWeatherPresenter;
    private ForecastAdapter mForecastAdapter;
    @BindView(R.id.recyclerview) RecyclerView mRecyclerView;
    @BindView(R.id.viewflipper) ViewFlipper mViewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        ButterKnife.bind(this);
        setPresenter(new WeatherPresenter(this));

        initRecyclerView();

        //request forecast list only on the first onCreate, ignore on rotation
        if (savedInstanceState == null) {
            requestForecastList();
        } else {
            //restore view state
            mViewFlipper.setDisplayedChild(savedInstanceState.getInt(KEY_CURRENT_CHILD));
            mForecastAdapter.setData(savedInstanceState.getParcelableArrayList(KEY_LIST_DATA));
        }
    }

    private void initRecyclerView() {
        mForecastAdapter = new ForecastAdapter(this);
        //in landscape we can render more columns
        int nbColumns = getResources().getInteger(R.integer.activity_weather_nb_columns);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, nbColumns));
        mRecyclerView.setAdapter(mForecastAdapter);
    }

    @OnClick(R.id.button_retry)
    public void onClickButtonRetry() {
        mViewFlipper.setDisplayedChild(VIEWSFLIPPER_CHILD_LOADING);
        requestForecastList();
    }

    private void requestForecastList() {
        mWeatherPresenter.loadForecastList(getString(R.string.api_weather_app_id), getString(R.string.api_weather_lang));
    }

    @Override public void setPresenter(WeatherPresenter presenter) {
        mWeatherPresenter = presenter;
    }

    @Override public void setListContent(List<Forecast> listForecast) {
        mForecastAdapter.setData(listForecast);
        mViewFlipper.setDisplayedChild(VIEWFLIPPER_CHILD_LIST);
    }

    @Override public void errorRecoveringList() {
        mViewFlipper.setDisplayedChild(VIEWFLIPPER_CHILD_RETRY);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(KEY_CURRENT_CHILD, mViewFlipper.getDisplayedChild());
        savedInstanceState.putParcelableArrayList(KEY_LIST_DATA, new ArrayList<>(mForecastAdapter.getData()));
    }
}

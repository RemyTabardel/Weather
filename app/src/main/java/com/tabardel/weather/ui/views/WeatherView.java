package com.tabardel.weather.ui.views;

import com.tabardel.weather.core.presenters.WeatherPresenter;
import com.tabardel.weather.services.models.Forecast;

import java.util.List;

/**
 * Created by TABARDEL_Remy on 18/12/2016.
 */

public interface WeatherView extends BaseView<WeatherPresenter> {
    @Override void setPresenter(WeatherPresenter presenter);

    void setListContent(List<Forecast> listForecast);
    void errorRecoveringList();
}

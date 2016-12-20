package com.tabardel.weather.services;

import com.tabardel.weather.core.presenters.WeatherPresenter;
import com.tabardel.weather.services.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by TABARDEL_Remy on 07/12/2016.
 */
@Singleton
@Component(modules = {AppModule.class,
        NetworkModule.class})
public interface AppComponent {
    void inject(WeatherPresenter injectedClass);

}

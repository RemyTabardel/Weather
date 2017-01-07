package com.tabardel.weather.services.network;

import android.content.Context;

import com.tabardel.weather.BuildConfig;
import com.tabardel.weather.R;
import com.tabardel.weather.services.network.api.OpenWeatherApi;
import com.tabardel.weather.services.network.retrofit.api.RetrofitOpenWeatherApi;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by TABARDEL_Remy on 08/12/2016.
 */
@Module
public class NetworkModule {
    @Provides
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE);
        }

        return logging;
    }

    @Provides
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(2000, TimeUnit.MILLISECONDS)
                .readTimeout(2000, TimeUnit.MILLISECONDS)
                .build();
    }

    @Provides
    @Singleton
    OpenWeatherApi provideOpenWeatherApi(Context context, OkHttpClient okHttpClient) {
        String baseUrl = context.getString(R.string.api_weather_base_url);
        return new RetrofitOpenWeatherApi(baseUrl, okHttpClient);
    }
}

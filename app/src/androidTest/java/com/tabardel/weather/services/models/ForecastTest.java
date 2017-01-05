package com.tabardel.weather.services.models;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import mock.ParcelableMock;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by TABARDEL_Remy on 04/01/2017.
 */
@SmallTest
public class ForecastTest {
    @Test
    public void testForecast_parcelable() {
        Forecast forecast = new Forecast(new Date(), null, 2.3, 5, null, 4.3, 1, 2, 8.9);
        Forecast forecastFromParcel = ParcelableMock.newInstance(forecast, Forecast.CREATOR);

        assertEquals(forecast.date, forecastFromParcel.date);
        assertEquals(forecast.temperature, forecastFromParcel.temperature);
        assertEquals(forecast.pressure, forecastFromParcel.pressure);
        assertEquals(forecast.humidity, forecastFromParcel.humidity);
        assertEquals(forecast.weathers, forecastFromParcel.weathers);
        assertEquals(forecast.speed, forecastFromParcel.speed);
        assertEquals(forecast.deg, forecastFromParcel.deg);
        assertEquals(forecast.clouds, forecastFromParcel.clouds);
        assertEquals(forecast.rain, forecastFromParcel.rain);
    }

    @Test
    public void testForecast_check_list_not_null() {
        Forecast forecast = new Forecast(new Date(), null, 2.3, 5, null, 4.3, 1, 2, 8.9);

        assertNotNull(forecast.weathers);
    }

    @Test
    public void testForecast_compareTo() {
        List<Forecast> forecasts = new ArrayList<>();
        forecasts.add(new Forecast(new Date(1000000000003L), null, 2.3, 5, null, 4.3, 1, 2, 8.9));
        forecasts.add(new Forecast(new Date(1000000000005L), null, 2.3, 5, null, 4.3, 1, 2, 8.9));
        forecasts.add(new Forecast(new Date(1000000000001L), null, 2.3, 5, null, 4.3, 1, 2, 8.9));
        forecasts.add(new Forecast(new Date(1000000000002L), null, 2.3, 5, null, 4.3, 1, 2, 8.9));
        forecasts.add(new Forecast(new Date(1000000000004L), null, 2.3, 5, null, 4.3, 1, 2, 8.9));

        Collections.sort(forecasts);

        assertEquals(1000000000001L, forecasts.get(0).date.getTime());
        assertEquals(1000000000002L, forecasts.get(1).date.getTime());
        assertEquals(1000000000003L, forecasts.get(2).date.getTime());
        assertEquals(1000000000004L, forecasts.get(3).date.getTime());
        assertEquals(1000000000005L, forecasts.get(4).date.getTime());
    }
}

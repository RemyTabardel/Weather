package com.tabardel.weather.services.models;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;

import mock.ParcelableMock;

import static junit.framework.Assert.assertEquals;

/**
 * Created by TABARDEL_Remy on 04/01/2017.
 */
@SmallTest
public class WeatherTest {
    @Test
    public void testWeather_parcelable() {
        Weather weather = new Weather(2, "main", "description", "icon");
        Weather weatherFromParcel = ParcelableMock.newInstance(weather, Weather.CREATOR);

        assertEquals(weather.id, weatherFromParcel.id);
        assertEquals(weather.main, weatherFromParcel.main);
        assertEquals(weather.description, weatherFromParcel.description);
        assertEquals(weather.icon, weatherFromParcel.icon);
    }
}

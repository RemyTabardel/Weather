package com.tabardel.weather.services.models;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;

import mock.ParcelableMock;

import static junit.framework.Assert.assertEquals;

/**
 * Created by TABARDEL_Remy on 04/01/2017.
 */
@SmallTest
public class TemperatureTest {
    @Test
    public void testTemperature_parcelable() {
        Temperature temperature = new Temperature(2.3, 2.4, 2.5, 2.6, 2.7, 2.8);
        Temperature temperatureFromParcel = ParcelableMock.newInstance(temperature, Temperature.CREATOR);

        assertEquals(temperature.day, temperatureFromParcel.day);
        assertEquals(temperature.eve, temperatureFromParcel.eve);
        assertEquals(temperature.max, temperatureFromParcel.max);
        assertEquals(temperature.min, temperatureFromParcel.min);
        assertEquals(temperature.morn, temperatureFromParcel.morn);
        assertEquals(temperature.night, temperatureFromParcel.night);
    }
}

package com.tabardel.weather.services.parsers.json;

import android.support.test.runner.AndroidJUnit4;
import android.util.JsonReader;

import com.tabardel.weather.services.models.Forecast;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mock.JsonReaderMock;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by TABARDEL_Remy on 05/01/2017.
 */
@RunWith(AndroidJUnit4.class)
public class ForecastParserTest {
    private JsonReader mJsonReader;

    @Before
    public void setUp() {
        mJsonReader = JsonReaderMock.newInstance("json/json_forecast_ForecastParser.json");
    }

    @Test
    public void testForecastParser_parse() throws Throwable {
        ForecastParser forecastParser = new ForecastParser();
        Forecast forecast = forecastParser.parse(mJsonReader);

        assertEquals(1481281200000L, forecast.date.getTime());
        assertNotNull(forecast.temperature);
        assertEquals(1028.8, forecast.pressure);
        assertEquals(94, forecast.humidity);
        assertNotNull(forecast.weathers);
        assertEquals(3.19, forecast.speed);
        assertEquals(183, forecast.deg);
        assertEquals(20, forecast.clouds);
    }
}

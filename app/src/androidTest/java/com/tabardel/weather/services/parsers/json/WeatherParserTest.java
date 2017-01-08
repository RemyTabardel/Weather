package com.tabardel.weather.services.parsers.json;

import android.support.test.runner.AndroidJUnit4;
import android.util.JsonReader;

import com.tabardel.weather.services.models.Weather;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mock.JsonReaderMock;

import static junit.framework.Assert.assertEquals;

/**
 * Created by TABARDEL_Remy on 05/01/2017.
 */
@RunWith(AndroidJUnit4.class)
public class WeatherParserTest {
    private JsonReader mJsonReader;

    @Before
    public void setUp() {
        mJsonReader = JsonReaderMock.newInstance("json/json_forecast_WeatherParser.json");
    }

    @Test
    public void testWeatherParser_parse() throws Throwable {
        WeatherParser weatherParser = new WeatherParser();
        Weather weather = weatherParser.parse(mJsonReader);

        assertEquals(801, weather.id);
        assertEquals("Clouds", weather.main);
        assertEquals("few clouds", weather.description);
        assertEquals("02n", weather.icon);
    }
}

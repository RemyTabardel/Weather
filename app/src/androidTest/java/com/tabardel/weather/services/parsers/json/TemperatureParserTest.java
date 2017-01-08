package com.tabardel.weather.services.parsers.json;

import android.support.test.runner.AndroidJUnit4;
import android.util.JsonReader;

import com.tabardel.weather.services.models.Temperature;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mock.JsonReaderMock;

import static junit.framework.Assert.assertEquals;

/**
 * Created by TABARDEL_Remy on 05/01/2017.
 */
@RunWith(AndroidJUnit4.class)
public class TemperatureParserTest {
    private JsonReader mJsonReader;

    @Before
    public void setUp() {
        mJsonReader = JsonReaderMock.newInstance("json/json_forecast_TemperatureParser.json");
    }

    @Test
    public void testTemperatureParser_parse() throws Throwable {
        TemperatureParser temperatureParser = new TemperatureParser();
        Temperature temperature = temperatureParser.parse(mJsonReader);

        assertEquals(5.21, temperature.day);
        assertEquals(2.27, temperature.min);
        assertEquals(5.21, temperature.max);
        assertEquals(2.27, temperature.night);
        assertEquals(5.21, temperature.eve);
        assertEquals(5.21, temperature.morn);
    }
}

package com.tabardel.weather.services.parsers.json;

import android.support.test.runner.AndroidJUnit4;
import android.util.JsonReader;

import com.tabardel.weather.services.models.ForecastList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mock.JsonReaderMock;
import static junit.framework.Assert.assertEquals;

/**
 * Created by TABARDEL_Remy on 05/01/2017.
 */
@RunWith(AndroidJUnit4.class)
public class ForecastListParserTest {
    private JsonReader mJsonReader;

    @Before
    public void setUp() {
        mJsonReader = JsonReaderMock.newInstance("json/json_forecast_ForecastListParser.json");
    }

    @Test
    public void testForecastListParser_parse() throws Throwable {
        ForecastListParser forecastListParser = new ForecastListParser();
        ForecastList forecastList = forecastListParser.parse(mJsonReader);

        assertEquals(5, forecastList.forecasts.size());
    }
}

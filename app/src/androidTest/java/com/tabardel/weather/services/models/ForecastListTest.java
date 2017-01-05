package com.tabardel.weather.services.models;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import mock.ParcelableMock;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by TABARDEL_Remy on 04/01/2017.
 */
@SmallTest
public class ForecastListTest {
    @Test
    public void testForecastList_parcelable() {
        ForecastList forecastList = new ForecastList(new ArrayList<>());
        ForecastList forecastListFromParcel = ParcelableMock.newInstance(forecastList, ForecastList.CREATOR);

        assertEquals(forecastList.forecasts, forecastListFromParcel.forecasts);
    }

    @Test
    public void testForecastList_check_list_not_null() {
        List<Forecast> list = null;
        ForecastList forecastList = new ForecastList(list);

        assertNotNull(forecastList.forecasts);
    }
}

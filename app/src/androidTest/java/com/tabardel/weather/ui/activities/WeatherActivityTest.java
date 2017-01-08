package com.tabardel.weather.ui.activities;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.runner.AndroidJUnit4;

import com.tabardel.weather.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import mock.ActivityMock;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by TABARDEL_Remy on 08/01/2017.
 */

@RunWith(AndroidJUnit4.class)
public class WeatherActivityTest extends ActivityMock<WeatherActivity> {
    public WeatherActivityTest() {
        super(WeatherActivity.class);
    }

    @Test
    public void testWeatherActivity_click_item() {
        // TODO: 08/01/2017 remove when netmodule is mock
        sleep(1000);

        onView(withId(R.id.recyclerview)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        //wait activity creation
        sleep(1000);

        onView(withId(R.id.textview_adds)).check(matches(isDisplayed()));
    }
}

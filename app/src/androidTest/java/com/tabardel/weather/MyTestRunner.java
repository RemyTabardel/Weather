package com.tabardel.weather;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

import mock.MyApplicationMock;

/**
 * Created by TABARDEL_Remy on 08/01/2017.
 */

public class MyTestRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, MyApplicationMock.class.getName(), context);
    }
}
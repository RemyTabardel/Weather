package com.tabardel.weather;

import android.app.Application;
import android.os.StrictMode;

import com.squareup.leakcanary.LeakCanary;
import com.tabardel.weather.services.AppComponent;
import com.tabardel.weather.services.AppModule;
import com.tabardel.weather.services.DaggerAppComponent;

/**
 * Created by TABARDEL_Remy on 07/12/2016.
 */

public class MyApplication extends Application {
    public static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        //init component for dependencies injections
        component = buildComponent();

        if (BuildConfig.DEBUG) {
            //detect memory leak
            LeakCanary.install(this);

            //detect bad implementations
            initStrictMode();
        }
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    private void initStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectAll()
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .penaltyDeath()
                .build());
    }
}

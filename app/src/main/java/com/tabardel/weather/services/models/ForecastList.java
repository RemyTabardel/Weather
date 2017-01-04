package com.tabardel.weather.services.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by TABARDEL_Remy on 08/12/2016.
 */

public class ForecastList implements Parcelable {
    public final List<Forecast> forecasts;

    public ForecastList(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }


    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.forecasts);
    }

    protected ForecastList(Parcel in) {
        this.forecasts = in.createTypedArrayList(Forecast.CREATOR);
    }

    public static final Parcelable.Creator<ForecastList> CREATOR = new Parcelable.Creator<ForecastList>() {
        @Override public ForecastList createFromParcel(Parcel source) {
            return new ForecastList(source);
        }

        @Override public ForecastList[] newArray(int size) {
            return new ForecastList[size];
        }
    };
}

package com.tabardel.weather.services.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by TABARDEL_Remy on 08/12/2016.
 */

public class Temperature implements Parcelable {
    public final double day;
    public final double min;
    public final double max;
    public final double night;
    public final double eve;
    public final double morn;

    public Temperature(double day,
                       double min,
                       double max,
                       double night,
                       double eve,
                       double morn) {
        this.day = day;
        this.min = min;
        this.max = max;
        this.night = night;
        this.eve = eve;
        this.morn = morn;
    }


    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.day);
        dest.writeDouble(this.min);
        dest.writeDouble(this.max);
        dest.writeDouble(this.night);
        dest.writeDouble(this.eve);
        dest.writeDouble(this.morn);
    }

    protected Temperature(Parcel in) {
        this.day = in.readDouble();
        this.min = in.readDouble();
        this.max = in.readDouble();
        this.night = in.readDouble();
        this.eve = in.readDouble();
        this.morn = in.readDouble();
    }

    public static final Parcelable.Creator<Temperature> CREATOR = new Parcelable.Creator<Temperature>() {
        @Override public Temperature createFromParcel(Parcel source) {
            return new Temperature(source);
        }

        @Override public Temperature[] newArray(int size) {
            return new Temperature[size];
        }
    };
}

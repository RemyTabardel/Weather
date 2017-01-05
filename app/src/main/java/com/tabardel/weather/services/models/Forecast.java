package com.tabardel.weather.services.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.tabardel.weather.tools.utils.ListUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by TABARDEL_Remy on 08/12/2016.
 */

public class Forecast implements Comparable<Forecast>, Parcelable {
    public final Date date;
    public final Temperature temperature;
    public final double pressure;
    public final int humidity;
    public final List<Weather> weathers;
    public final double speed;
    public final int deg;
    public final int clouds;
    public final double rain;

    public Forecast(Date date,
                    Temperature temperature,
                    double pressure,
                    int humidity,
                    List<Weather> weathers,
                    double speed,
                    int deg,
                    int clouds,
                    double rain) {
        this.date = date;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        //avoid null list
        this.weathers = ListUtils.defaultIfNull(weathers);
        this.speed = speed;
        this.deg = deg;
        this.clouds = clouds;
        this.rain = rain;
    }

    @Override public int compareTo(Forecast another) {
        return this.date.compareTo(another.date);
    }


    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.date != null ? this.date.getTime() : -1);
        dest.writeParcelable(this.temperature, flags);
        dest.writeDouble(this.pressure);
        dest.writeInt(this.humidity);
        dest.writeTypedList(this.weathers);
        dest.writeDouble(this.speed);
        dest.writeInt(this.deg);
        dest.writeInt(this.clouds);
        dest.writeDouble(this.rain);
    }

    protected Forecast(Parcel in) {
        long tmpDate = in.readLong();
        this.date = tmpDate == -1 ? null : new Date(tmpDate);
        this.temperature = in.readParcelable(Temperature.class.getClassLoader());
        this.pressure = in.readDouble();
        this.humidity = in.readInt();
        this.weathers = in.createTypedArrayList(Weather.CREATOR);
        this.speed = in.readDouble();
        this.deg = in.readInt();
        this.clouds = in.readInt();
        this.rain = in.readDouble();
    }

    public static final Creator<Forecast> CREATOR = new Creator<Forecast>() {
        @Override public Forecast createFromParcel(Parcel source) {
            return new Forecast(source);
        }

        @Override public Forecast[] newArray(int size) {
            return new Forecast[size];
        }
    };
}

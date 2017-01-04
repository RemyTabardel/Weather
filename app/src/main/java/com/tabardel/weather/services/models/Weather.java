package com.tabardel.weather.services.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by TABARDEL_Remy on 08/12/2016.
 */

public class Weather implements Parcelable {
    public final int id;
    public final String main;
    public final String description;
    public final String icon;

    public Weather(int id,
                   String main,
                   String description,
                   String icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }


    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.main);
        dest.writeString(this.description);
        dest.writeString(this.icon);
    }

    protected Weather(Parcel in) {
        this.id = in.readInt();
        this.main = in.readString();
        this.description = in.readString();
        this.icon = in.readString();
    }

    public static final Parcelable.Creator<Weather> CREATOR = new Parcelable.Creator<Weather>() {
        @Override public Weather createFromParcel(Parcel source) {
            return new Weather(source);
        }

        @Override public Weather[] newArray(int size) {
            return new Weather[size];
        }
    };
}

package com.tabardel.weather.services.models;

/**
 * Created by TABARDEL_Remy on 08/12/2016.
 */

public class City {
    public final int id;
    public final String name;
    public final double latitude, longitude;
    public final String country;

    public City(int id, String name, double latitude, double longitude, String country) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
    }
}

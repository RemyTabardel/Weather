package com.tabardel.weather.services.parsers.json;

import android.util.JsonReader;
import android.util.JsonToken;

import com.tabardel.weather.services.models.Forecast;
import com.tabardel.weather.services.models.Temperature;
import com.tabardel.weather.services.models.Weather;
import com.tabardel.weather.services.parsers.AbstractParser;

import java.io.IOException;
import java.util.Date;

/**
 * Created by TABARDEL_Remy on 20/12/2016.
 */

public class ForecastParser extends AbstractParser<Forecast> {
    @Override public Forecast parse(JsonReader reader) throws IOException {
        clear();
        TemperatureParser temperatureParser = new TemperatureParser();
        WeatherParser weatherParser = new WeatherParser();

        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();

            if (name.equals("dt")) {
                long l = reader.nextLong();
                setValue(name, new Date(l));
            } else if (name.equals("temp")) {
                Temperature temperature = temperatureParser.parse(reader);
                setValue(name, temperature);
            } else if (name.equals("pressure")) {
                setValue(name, reader.nextDouble());
            } else if (name.equals("humidity")) {
                setValue(name, reader.nextInt());
            } else if (name.equals("weather")) {
                reader.beginArray();

                while (reader.hasNext()) {
                    Weather weather = weatherParser.parse(reader);
                    addListValue(name, weather);
                }

                reader.endArray();
            } else if (name.equals("speed")) {
                setValue(name, reader.nextDouble());
            } else if (name.equals("deg")) {
                setValue(name, reader.nextInt());
            } else if (name.equals("clouds")) {
                setValue(name, reader.nextInt());
            } else if (name.equals("rain") && reader.peek() != JsonToken.NULL) {
                setValue(name, reader.nextDouble());
            } else {
                reader.skipValue();
            }
        }

        reader.endObject();

        return new Forecast(getValue("dt"),
                getValue("temp"),
                getValue("pressure"),
                getValue("humidity"),
                getList("weather"),
                getValue("speed"),
                getValue("deg"),
                getValue("clouds"),
                containsValue("rain") ? getValue("rain") : 0);
    }
}

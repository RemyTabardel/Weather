package com.tabardel.weather.services.parsers.json;

import android.util.JsonReader;

import com.tabardel.weather.services.models.Weather;
import com.tabardel.weather.services.parsers.AbstractParser;

import java.io.IOException;

/**
 * Created by TABARDEL_Remy on 04/01/2017.
 */

public class WeatherParser extends AbstractParser<Weather> {
    @Override public Weather parse(JsonReader reader) throws IOException {
        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();

            if (name.equals("id")) {
                setValue(name, reader.nextInt());
            } else if (name.equals("main")) {
                setValue(name, reader.nextString());
            } else if (name.equals("description")) {
                setValue(name, reader.nextString());
            } else if (name.equals("icon")) {
                setValue(name, reader.nextString());
            } else {
                reader.skipValue();
            }
        }

        reader.endObject();

        return new Weather(getValue("id"),
                getValue("main"),
                getValue("description"),
                getValue("icon"));
    }
}

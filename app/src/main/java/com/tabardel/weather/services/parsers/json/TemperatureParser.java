package com.tabardel.weather.services.parsers.json;

import android.util.JsonReader;

import com.tabardel.weather.services.models.Temperature;
import com.tabardel.weather.services.parsers.AbstractParser;

import java.io.IOException;

/**
 * Created by TABARDEL_Remy on 04/01/2017.
 */

public class TemperatureParser extends AbstractParser<Temperature> {
    @Override public Temperature parse(JsonReader reader) throws IOException {
        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();

            if (name.equals("day")) {
                setValue(name, reader.nextDouble());
            } else if (name.equals("min")) {
                setValue(name, reader.nextDouble());
            } else if (name.equals("max")) {
                setValue(name, reader.nextDouble());
            } else if (name.equals("night")) {
                setValue(name, reader.nextDouble());
            } else if (name.equals("eve")) {
                setValue(name, reader.nextDouble());
            } else if (name.equals("morn")) {
                setValue(name, reader.nextDouble());
            } else {
                reader.skipValue();
            }
        }

        reader.endObject();

        return new Temperature(getValue("day"),
                getValue("min"),
                getValue("max"),
                getValue("night"),
                getValue("eve"),
                getValue("morn"));
    }
}

package com.tabardel.weather.services.parsers.json;

import android.util.JsonReader;

import com.tabardel.weather.services.models.Forecast;
import com.tabardel.weather.services.models.ForecastList;
import com.tabardel.weather.services.parsers.AbstractParser;

import java.io.IOException;

/**
 * Created by TABARDEL_Remy on 09/12/2016.
 */

public class ForecastListParser extends AbstractParser<ForecastList> {
    @Override public ForecastList parse(JsonReader reader) throws IOException {
        ForecastParser forecastParser = new ForecastParser();

        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();

            if (name.equals("list")) {
                reader.beginArray();

                while (reader.hasNext()) {
                    Forecast forecast = forecastParser.parse(reader);
                    addListValue(name, forecast);
                }

                reader.endArray();
            } else {
                reader.skipValue();
            }
        }

        reader.endObject();

        return new ForecastList(getValue("list"));
    }
}

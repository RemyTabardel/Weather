package com.tabardel.weather.services.parsers.json;

import android.util.JsonReader;

import com.tabardel.weather.services.models.Forecast;
import com.tabardel.weather.services.parsers.AbstractParser;

import java.io.IOException;
import java.util.Date;

/**
 * Created by TABARDEL_Remy on 20/12/2016.
 */

public class ForecastParser extends AbstractParser<Forecast> {
    @Override public Forecast parse(JsonReader reader) throws IOException {
        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();

            reader.skipValue();
        }

        reader.endObject();

        return new Forecast(new Date(), null, 0, 0, null, 0, 0, 0, 0);
    }
}

package com.tabardel.weather.services.network.parsers.json;

import android.util.JsonReader;

import com.tabardel.weather.services.models.ForecastList;
import com.tabardel.weather.services.network.parsers.AbstractParser;

import java.io.IOException;

/**
 * Created by TABARDEL_Remy on 09/12/2016.
 */

public class ForecastListParser extends AbstractParser<ForecastList> {
    @Override public ForecastList parse(JsonReader reader) throws IOException {

        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();

            if (name.equals("city")) {

            } else if (name.equals("list")) {

            }
        }

        reader.endObject();
        reader.close();

        return null;
    }
}

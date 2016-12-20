package com.tabardel.weather.services.network.retrofit.converters;

import android.util.JsonReader;

import com.tabardel.weather.services.models.ForecastList;
import com.tabardel.weather.services.parsers.json.ForecastListParser;

import java.io.IOException;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by TABARDEL_Remy on 20/12/2016.
 */

public class ForecastListConverter extends AbstractConverter<ForecastList> {
    public ForecastListConverter() {
        super(ForecastList.class);
    }

    @Override public <U> Converter<U, RequestBody> getRequestConverter() {
        return U -> null;
    }

    @Override public Converter<ResponseBody, ForecastList> getResponseConverter() {
        return new Converter<ResponseBody, ForecastList>() {
            @Override
            public ForecastList convert(ResponseBody value) throws IOException {
                ForecastListParser forecastListParser = new ForecastListParser();

                JsonReader reader = new JsonReader(value.charStream());

                ForecastList forecastList = forecastListParser.parse(reader);

                reader.close();

                return forecastList;
            }
        };
    }
}

package com.tabardel.weather.services.network.parsers;

import android.util.JsonReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TABARDEL_Remy on 09/12/2016.
 */

public abstract class AbstractParser<T> {
    private Map<String, Object> mValues;

    public AbstractParser() {
        mValues = new HashMap<>();
    }

    protected void setValue(String name, Object value) {
        mValues.put(name, value);
    }

    protected <U> U getValue(String name) {
        return (U) mValues.get(name);
    }


    public abstract T parse(final JsonReader reader) throws IOException;
}

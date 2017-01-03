package com.tabardel.weather.services.parsers;

import android.util.JsonReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TABARDEL_Remy on 09/12/2016.
 */

public abstract class AbstractParser<T> {
    private Map<String, Object> mValues;

    public AbstractParser() {
        mValues = new HashMap<>();
    }

    protected void setValue(String key, Object value) {
        mValues.put(key, value);
    }

    protected void addListValue(String key, Object value) {
        getList(key).add(value);
    }

    public void clear() {
        mValues.clear();
    }

    protected <U> U getValue(String key) throws IOException {
        U value = null;

        if (mValues.containsKey(key)) {
            value = (U) mValues.get(key);
        }

        if (value instanceof ArrayList) {
            //to recover list we need to use getList instead
            throw new IOException("You must use getList method to recover parsed list");
        }

        return value;
    }

    /**
     * @param key
     * @return list with items added by addListValue
     */
    protected List getList(String key) {
        //if no item we return empty list
        if (mValues.containsKey(key) == false) {
            mValues.put(key, new ArrayList<>());
        }

        return (List) mValues.get(key);
    }

    public abstract T parse(final JsonReader reader) throws IOException;
}

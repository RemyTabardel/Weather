package com.tabardel.weather.services.network.retrofit.converters;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by TABARDEL_Remy on 20/12/2016.
 */

public abstract class AbstractConverter<T> {
    private Class<T> mType;

    public AbstractConverter(Class<T> type) {
        mType = type;
    }

    public Class<T> getType() {
        return mType;
    }

    public abstract <U> Converter<U, RequestBody> getRequestConverter();

    public abstract Converter<ResponseBody, T> getResponseConverter();
}
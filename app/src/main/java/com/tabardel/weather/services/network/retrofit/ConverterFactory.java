package com.tabardel.weather.services.network.retrofit;

import com.tabardel.weather.services.network.retrofit.converters.AbstractConverter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by TABARDEL_Remy on 20/12/2016.
 */

public class ConverterFactory extends Converter.Factory {
    private Map<Type, AbstractConverter> mConverters;

    public ConverterFactory() {
        mConverters = new HashMap<>();
    }

    public void addConverter(AbstractConverter converter) {
        mConverters.put(converter.getType(), converter);
    }

    @Override public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return mConverters.get(type).getRequestConverter();
    }

    @Override public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return mConverters.get(type).getResponseConverter();
    }
}
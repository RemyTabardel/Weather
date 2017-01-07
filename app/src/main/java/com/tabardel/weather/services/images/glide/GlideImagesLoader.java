package com.tabardel.weather.services.images.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tabardel.weather.R;
import com.tabardel.weather.services.images.ImagesLoader;

/**
 * Created by TABARDEL_Remy on 07/01/2017.
 */

public class GlideImagesLoader implements ImagesLoader {
    private Context mAppContext;
    private String mBaseUrl, mExt;

    public GlideImagesLoader(Context appContext) {
        mAppContext = appContext;
        mBaseUrl = mAppContext.getString(R.string.api_weather_icon_base_url);
        mExt = mAppContext.getString(R.string.api_weather_icon_ext);
    }

    @Override public void loadWeatherIcon(ImageView imageView, String icon) {
        Glide.with(mAppContext).load(mBaseUrl + icon + mExt).into(imageView);
    }
}

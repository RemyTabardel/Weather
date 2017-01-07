package com.tabardel.weather.services.images;

import android.content.Context;

import com.tabardel.weather.services.images.glide.GlideImagesLoader;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TABARDEL_Remy on 07/01/2017.
 */
@Module
public class ImagesModule {
    @Provides
    ImagesLoader provideImagesLoader(Context context) {
        return new GlideImagesLoader(context);
    }
}

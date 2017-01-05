package com.tabardel.weather.tools.utils;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;

/**
 * Created by TABARDEL_Remy on 05/01/2017.
 */

public class AssetsUtils {
    public static String read(Context context, String filename) {
        String text = null;

        if (context != null) {
            AssetManager assetManager = context.getResources().getAssets();

            try {
                text = FileUtils.read(assetManager.open(filename));
            } catch (IOException e) {
                LogUtils.e("could not open file", e);
            }
        }

        return text;
    }
}

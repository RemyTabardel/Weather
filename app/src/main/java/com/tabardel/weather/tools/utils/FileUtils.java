package com.tabardel.weather.tools.utils;

import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by TABARDEL_Remy on 05/01/2017.
 */

public class FileUtils {
    public static String read(String filename) {
        String text = null;

        if (TextUtils.isEmpty(filename) == false) {
            try {
                text = read(new FileInputStream(filename));
            } catch (FileNotFoundException e) {
                LogUtils.e("could not find file", e);
            }
        }

        return text;
    }

    public static String read(InputStream inputStream) {
        String text = null;

        if (inputStream != null) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();
                String line = null;

                while ((line = reader.readLine()) != null) {
                    stringBuffer.append(line);
                }
                text = stringBuffer.toString();
            } catch (IOException e) {
                LogUtils.e("could not find file", e);
            }
        }

        return text;
    }
}

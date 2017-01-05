package mock;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.util.JsonReader;

import com.tabardel.weather.tools.utils.AssetsUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by TABARDEL_Remy on 05/01/2017.
 */

public class JsonReaderMock {
    public static JsonReader newInstance(String jsonFilename) {
        Context appContext = InstrumentationRegistry.getContext();
        String json = AssetsUtils.read(appContext, jsonFilename);
        InputStream inputStream = new ByteArrayInputStream(json.getBytes(Charset.forName("UTF-8")));
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        return new JsonReader(inputStreamReader);
    }
}

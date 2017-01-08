package mock;

import com.tabardel.weather.MyApplication;
import com.tabardel.weather.services.AppComponent;
import com.tabardel.weather.services.AppModule;

/**
 * Created by TABARDEL_Remy on 08/01/2017.
 */

public class MyApplicationMock extends MyApplication {

    @Override
    protected AppComponent buildComponent() {
        // TODO: 08/01/2017 add new NetModuleMock
        return DaggerAppComponentMock.builder()
                .appModule(new AppModule(this))
                .build();
    }

}
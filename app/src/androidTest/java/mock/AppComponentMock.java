package mock;

import com.tabardel.weather.services.AppComponent;
import com.tabardel.weather.services.AppModule;
import com.tabardel.weather.services.images.ImagesModule;
import com.tabardel.weather.services.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by TABARDEL_Remy on 08/01/2017.
 */

@Singleton
@Component(modules = {AppModule.class,
        NetworkModule.class, // TODO: 08/01/2017 mock this module
        ImagesModule.class})
public interface AppComponentMock extends AppComponent {

}
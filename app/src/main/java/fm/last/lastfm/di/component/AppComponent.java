package fm.last.lastfm.di.component;

import dagger.Component;
import fm.last.lastfm.MainApplication;
import fm.last.lastfm.data.DataManager;
import fm.last.lastfm.di.module.AppModule;
import fm.last.lastfm.di.module.DataModule;
import fm.last.lastfm.di.module.NetworkModule;


@Component(modules = {AppModule.class,NetworkModule.class, DataModule.class})
public interface AppComponent {
    void inject(MainApplication application);
    DataManager getDataManager();
}

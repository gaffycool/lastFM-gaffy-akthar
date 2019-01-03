package fm.last.lastfm.di.component;

import dagger.Component;
import fm.last.lastfm.MainApplication;
import fm.last.lastfm.di.module.AppModule;
import fm.last.lastfm.di.module.NetworkModule;


@Component(modules = {AppModule.class,NetworkModule.class})
public interface AppComponent {
    void inject(MainApplication application);
}

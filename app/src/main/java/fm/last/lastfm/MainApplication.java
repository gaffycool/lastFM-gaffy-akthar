package fm.last.lastfm;

import android.app.Application;

import fm.last.lastfm.di.component.AppComponent;
import fm.last.lastfm.di.component.DaggerAppComponent;
import fm.last.lastfm.di.module.AppModule;

public class MainApplication extends Application {

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }
}

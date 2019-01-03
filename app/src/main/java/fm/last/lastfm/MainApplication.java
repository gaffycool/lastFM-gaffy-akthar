package fm.last.lastfm;

import android.app.Application;

import fm.last.lastfm.di.component.AppComponent;
import fm.last.lastfm.di.component.DaggerAppComponent;
import fm.last.lastfm.di.module.AppModule;

public class MainApplication extends Application {

    private AppComponent appComponent;
    private static MainApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }
    public static MainApplication getInstance(){
        return instance;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

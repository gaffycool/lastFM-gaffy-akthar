package fm.last.lastfm.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import fm.last.lastfm.di.qualifier.ApplicationContext;

@Module
public class AppModule {
    private Application mApplication;
    public AppModule(Application application){
        this.mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext(){
        return mApplication;
    }

    @Provides
    Application provideApplication(){
        return mApplication;
    }
}

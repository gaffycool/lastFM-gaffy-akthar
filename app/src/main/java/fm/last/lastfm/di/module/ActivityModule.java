package fm.last.lastfm.di.module;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import fm.last.lastfm.di.qualifier.ActivityContext;

@Module
public class ActivityModule {
    private Activity mActivity;
    public ActivityModule(Activity activity){
        this.mActivity = activity;
    }
    @Provides
    @ActivityContext
    public Context provideContext(){
        return mActivity;
    }
}

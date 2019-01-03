package fm.last.lastfm.di.module;

import dagger.Module;
import dagger.Provides;
import fm.last.lastfm.data.DataManager;
import fm.last.lastfm.data.network.RestApiHelper;

@Module
public class DataModule {
    @Provides
    public DataManager provideDataManager(RestApiHelper restApiHelper){
        return new DataManager(restApiHelper);
    }
}

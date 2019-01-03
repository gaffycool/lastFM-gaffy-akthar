package fm.last.lastfm.data;

import fm.last.lastfm.data.network.RestApiHelper;

public class DataManager {
    private RestApiHelper mRestApiHelper;
    public DataManager(RestApiHelper restApiHelper){
        this.mRestApiHelper = restApiHelper;
    }
}

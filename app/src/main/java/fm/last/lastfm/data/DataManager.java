package fm.last.lastfm.data;

import fm.last.lastfm.data.network.RestApiHelper;
import fm.last.lastfm.data.network.response.SearchResponse;
import io.reactivex.Single;

public class DataManager {
    private RestApiHelper mRestApiHelper;
    public DataManager(RestApiHelper restApiHelper){
        this.mRestApiHelper = restApiHelper;
    }
    public Single<SearchResponse> searchAlbum(String keyword){
        return mRestApiHelper.searchAlbum(keyword);
    }
}

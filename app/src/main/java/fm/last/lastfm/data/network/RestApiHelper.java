package fm.last.lastfm.data.network;

import fm.last.lastfm.data.network.response.SearchResponse;
import io.reactivex.Single;

public class RestApiHelper {

    private WebServices mWebServices;

    public RestApiHelper(WebServices webServices) {
        this.mWebServices = webServices;
    }

    public Single<SearchResponse> searchAlbum(String keyWord) {
        return mWebServices.searchAlbum(keyWord);
    }

}

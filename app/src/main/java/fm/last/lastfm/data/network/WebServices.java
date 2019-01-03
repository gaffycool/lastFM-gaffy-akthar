package fm.last.lastfm.data.network;

import fm.last.lastfm.Constant;
import fm.last.lastfm.data.network.response.SearchResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebServices {
    @GET("/2.0/?method=album.search&api_key="+Constant.API_KEY +"&format=json")
    Single<SearchResponse> searchAlbum(@Query("album") String keyword);
}

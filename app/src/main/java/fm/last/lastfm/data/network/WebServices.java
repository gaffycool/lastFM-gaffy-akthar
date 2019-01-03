package fm.last.lastfm.data.network;

import fm.last.lastfm.data.network.response.SearchResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebServices {
    @GET("/2.0/?method=album.search&api_key=6867e7978cca6391a71a5d325fa7f93c&format=json")
    Single<SearchResponse> searchAlbum(@Query("album") String keyword);
}

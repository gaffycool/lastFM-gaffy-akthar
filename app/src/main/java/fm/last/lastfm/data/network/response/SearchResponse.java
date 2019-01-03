
package fm.last.lastfm.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResponse {

    @SerializedName("results")
    @Expose
    public Results results;

}

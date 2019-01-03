
package fm.last.lastfm.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("opensearch:Query")
    @Expose
    public OpensearchQuery opensearchQuery;
    @SerializedName("opensearch:totalResults")
    @Expose
    public String opensearchTotalResults;
    @SerializedName("opensearch:startIndex")
    @Expose
    public String opensearchStartIndex;
    @SerializedName("opensearch:itemsPerPage")
    @Expose
    public String opensearchItemsPerPage;
    @SerializedName("albummatches")
    @Expose
    public Albummatches albummatches;
    @SerializedName("@attr")
    @Expose
    public Attr attr;

}

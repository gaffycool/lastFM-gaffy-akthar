
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

    public OpensearchQuery getOpensearchQuery() {
        return opensearchQuery;
    }

    public void setOpensearchQuery(OpensearchQuery opensearchQuery) {
        this.opensearchQuery = opensearchQuery;
    }

    public String getOpensearchTotalResults() {
        return opensearchTotalResults;
    }

    public void setOpensearchTotalResults(String opensearchTotalResults) {
        this.opensearchTotalResults = opensearchTotalResults;
    }

    public String getOpensearchStartIndex() {
        return opensearchStartIndex;
    }

    public void setOpensearchStartIndex(String opensearchStartIndex) {
        this.opensearchStartIndex = opensearchStartIndex;
    }

    public String getOpensearchItemsPerPage() {
        return opensearchItemsPerPage;
    }

    public void setOpensearchItemsPerPage(String opensearchItemsPerPage) {
        this.opensearchItemsPerPage = opensearchItemsPerPage;
    }

    public Albummatches getAlbummatches() {
        return albummatches;
    }

    public void setAlbummatches(Albummatches albummatches) {
        this.albummatches = albummatches;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }
}

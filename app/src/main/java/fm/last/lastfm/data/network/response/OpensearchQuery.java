
package fm.last.lastfm.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpensearchQuery {

    @SerializedName("#text")
    @Expose
    public String text;
    @SerializedName("role")
    @Expose
    public String role;
    @SerializedName("searchTerms")
    @Expose
    public String searchTerms;
    @SerializedName("startPage")
    @Expose
    public String startPage;

}

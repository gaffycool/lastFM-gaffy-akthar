
package fm.last.lastfm.data.network.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Albummatches {

    @SerializedName("album")
    @Expose
    public List<Album> album = null;

}

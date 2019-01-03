
package fm.last.lastfm.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attr {

    @SerializedName("for")
    @Expose
    public String _for;

    public String get_for() {
        return _for;
    }

    public void set_for(String _for) {
        this._for = _for;
    }
}

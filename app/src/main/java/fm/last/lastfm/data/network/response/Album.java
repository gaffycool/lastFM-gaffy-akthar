
package fm.last.lastfm.data.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Album  implements Parcelable{

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("artist")
    @Expose
    public String artist;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("image")
    @Expose
    public List<Image> image = null;
    @SerializedName("streamable")
    @Expose
    public String streamable;
    @SerializedName("mbid")
    @Expose
    public String mbid;

    protected Album(Parcel in) {
        name = in.readString();
        artist = in.readString();
        url = in.readString();
        image = in.createTypedArrayList(Image.CREATOR);
        streamable = in.readString();
        mbid = in.readString();
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

    public String getStreamable() {
        return streamable;
    }

    public void setStreamable(String streamable) {
        this.streamable = streamable;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(artist);
        dest.writeString(url);
        dest.writeTypedList(image);
        dest.writeString(streamable);
        dest.writeString(mbid);
    }
}

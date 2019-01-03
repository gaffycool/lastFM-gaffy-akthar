package fm.last.lastfm.ui.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import fm.last.lastfm.R;
import fm.last.lastfm.listener.AlbumOnClickListener;
import fm.last.lastfm.data.network.response.Album;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumViewHolder> {

    private List<Album> albums;
    private AlbumOnClickListener albumOnClickListener;
    private Context context;

    public AlbumAdapter(List<Album> album, AlbumOnClickListener albumOnClickListener,
                        Context context) {
        this.albums = album;
        this.albumOnClickListener = albumOnClickListener;
        this.context = context;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new AlbumViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.view_holder_album,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder albumViewHolder, int i) {
        final Album album = albums.get(i);
        albumViewHolder.tvTitle.setText(album.name);
        albumViewHolder.tvArtist.setText(album.artist);
        Glide.with(context).load(album.image.get(4).text).into(albumViewHolder.ivCover);
        albumViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                albumOnClickListener.albumOnClick(album);
            }
        });
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }
}

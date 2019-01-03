package fm.last.lastfm.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.last.lastfm.R;

class AlbumViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.ivCover)
    public ImageView ivCover;
    @BindView(R.id.tvTitle)
    public TextView tvTitle;
    @BindView(R.id.tvArtist)
    public TextView tvArtist;

    public AlbumViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}

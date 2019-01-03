package fm.last.lastfm.ui.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.last.lastfm.Constant;
import fm.last.lastfm.R;
import fm.last.lastfm.data.network.response.Album;
import fm.last.lastfm.ui.base.BaseActivity;

public class DetailActivity extends BaseActivity {

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @BindView(R.id.tvArtist)
    TextView tvArtist;

    @BindView(R.id.ivCover)
    ImageView ivCover;

    Album album;


    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_detail;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
        ButterKnife.bind(this);

        album = getIntent().getParcelableExtra(Constant.KEY_ALBUM);
        tvTitle.setText(album.name);
        tvArtist.setText(album.artist);
        Glide.with(this).load(album.image.get(3).text).into(ivCover);

    }

    @OnClick(R.id.btnOpenWebSide)
    public void onClick(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(album.url));
        startActivity(intent);
    }
}

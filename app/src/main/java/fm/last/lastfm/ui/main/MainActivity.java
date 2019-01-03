package fm.last.lastfm.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.last.lastfm.Constant;
import fm.last.lastfm.R;
import fm.last.lastfm.ui.base.BaseActivity;
import fm.last.lastfm.ui.detail.DetailActivity;
import fm.last.lastfm.listener.AlbumOnClickListener;
import fm.last.lastfm.data.network.response.Album;

public class MainActivity extends BaseActivity implements MainContract.View {

    @BindView(R.id.etSearch)
    EditText etSearch;
    @BindView(R.id.rvAlbums)
    RecyclerView rvAlbum;


    AlbumOnClickListener albumOnClickListener = new AlbumOnClickListener() {
        @Override
        public void albumOnClick(Album album) {
            Intent intent = new Intent(MainActivity.this,DetailActivity.class);
            intent.putExtra(Constant.KEY_ALBUM,album);
            startActivity(intent);
        }
    };

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Inject
    MainPresenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        getComponent().inject(this);
        presenter.attach(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvAlbum.setLayoutManager(linearLayoutManager);

    }

    @OnClick(R.id.btnSearch)
    public void searchOnClick(){
        presenter.loadData(etSearch.getText().toString());
    }
    @Override
    public void displayData(List<Album> albumList) {

        AlbumAdapter adapter = new AlbumAdapter(albumList,albumOnClickListener,this);
        rvAlbum.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }
}

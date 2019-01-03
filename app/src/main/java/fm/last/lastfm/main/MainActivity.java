package fm.last.lastfm.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import fm.last.lastfm.R;
import fm.last.lastfm.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainContract.View {

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    MainContract.Presenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainPresenter();
        presenter.attach(this);
        presenter.loadData("");
    }

    @Override
    public void displayData() {

    }
}

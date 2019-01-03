package fm.last.lastfm.ui.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;

import fm.last.lastfm.R;
import fm.last.lastfm.ui.base.BaseActivity;

public class DetailActivity extends BaseActivity {
    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_detail;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
    }
}

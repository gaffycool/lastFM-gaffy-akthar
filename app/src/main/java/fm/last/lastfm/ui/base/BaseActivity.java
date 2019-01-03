package fm.last.lastfm.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import fm.last.lastfm.MainApplication;
import fm.last.lastfm.di.component.ActivityComponent;
import fm.last.lastfm.di.component.DaggerActivityComponent;

public abstract class BaseActivity extends AppCompatActivity implements MvpView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
    }

    public abstract int getLayoutResourceId();

    @Override
    public void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayToast(int messageResourceId) {
        Toast.makeText(this, messageResourceId, Toast.LENGTH_SHORT).show();
    }
    public ActivityComponent getComponent(){
        return DaggerActivityComponent.builder().appComponent(MainApplication.getInstance().getAppComponent())
                .build();
    }
}


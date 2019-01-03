package fm.last.lastfm.di.component;

import dagger.Component;
import fm.last.lastfm.di.module.ActivityModule;
import fm.last.lastfm.ui.detail.DetailActivity;
import fm.last.lastfm.ui.main.MainActivity;

@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
    void inject(DetailActivity activity);
}

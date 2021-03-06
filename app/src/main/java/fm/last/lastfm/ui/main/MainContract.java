package fm.last.lastfm.ui.main;

import java.util.List;

import fm.last.lastfm.ui.base.MvpPresenter;
import fm.last.lastfm.ui.base.MvpView;
import fm.last.lastfm.data.network.response.Album;

public class MainContract {
    public interface View extends MvpView{
        void displayData(List<Album> albumList);
    }
    public interface Presenter extends MvpPresenter<View>{
        void loadData(String keyword);
    }
}

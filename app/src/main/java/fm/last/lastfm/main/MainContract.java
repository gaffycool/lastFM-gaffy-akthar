package fm.last.lastfm.main;

import fm.last.lastfm.base.MvpPresenter;
import fm.last.lastfm.base.MvpView;

public class MainContract {
    interface View extends MvpView{
        void displayData();
    }
    interface Presenter extends MvpPresenter<View>{
        void loadData(String keyword);
    }
}

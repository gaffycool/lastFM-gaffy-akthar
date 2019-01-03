package fm.last.lastfm.main;

import fm.last.lastfm.base.BaseMvpPresenter;

public class MainPresenter extends BaseMvpPresenter<MainContract.View> implements MainContract.Presenter {

    @Override
    public void loadData(String keyword) {
        if(isViewAttached()){
            getMvpView().displayData();
        }
    }
}

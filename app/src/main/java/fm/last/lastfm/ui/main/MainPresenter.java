package fm.last.lastfm.ui.main;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import java.io.IOException;

import javax.inject.Inject;

import fm.last.lastfm.data.DataManager;
import fm.last.lastfm.data.network.response.Error;
import fm.last.lastfm.data.network.response.SearchResponse;
import fm.last.lastfm.ui.base.BaseMvpPresenter;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BaseMvpPresenter<MainContract.View>
        implements MainContract.Presenter {
    private DataManager mDataManager;
    private CompositeDisposable disposable = new CompositeDisposable();
    @Inject
    public MainPresenter(DataManager dataManager){
        this.mDataManager = dataManager;
    }
    @Override
    public void loadData(String keyword) {
        mDataManager.searchAlbum(keyword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<SearchResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onSuccess(SearchResponse searchResponse) {
                        if(isViewAttached()){
                                getMvpView().displayData(searchResponse.getResults().getAlbummatches()
                                        .getAlbum());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        handleError(e);
                    }
                });
    }
    private void handleError(Throwable e){
        e.printStackTrace();
        if(isViewAttached()){
            if(e instanceof HttpException){
                HttpException httpException = (HttpException)e;
                if(httpException.response().errorBody()!=null) {
                    try {
                        getMvpView().displayToast(new Gson().fromJson(httpException.response().errorBody().string(),Error.class).getMessage());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                        getMvpView().displayToast(e1.getLocalizedMessage());
                    }
                }else{
                    getMvpView().displayToast(e.getLocalizedMessage());
                }
            }else {
                getMvpView().displayToast(e.getLocalizedMessage());
            }
        }
    }
    @Override
    public void detach() {
        disposable.clear();
        super.detach();
    }
}

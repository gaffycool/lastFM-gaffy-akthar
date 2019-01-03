package fm.last.lastfm.ui.base;

public class BaseMvpPresenter<T extends MvpView>  implements MvpPresenter<T> {

    private T view;

    public void attach(T view){
        this.view = view;
    }
    public  void detach(){
        this.view = null;
    }
    public boolean isViewAttached(){
        return view!=null;
    }
    public T getMvpView(){
        return view;
    }
}

package fm.last.lastfm.ui.base;

public interface MvpPresenter<T> {
    void attach(T view);
    void detach();
}

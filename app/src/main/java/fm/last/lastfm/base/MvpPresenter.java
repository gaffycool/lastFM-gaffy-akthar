package fm.last.lastfm.base;

public interface MvpPresenter<T> {
    void attach(T view);
    void detach();
}

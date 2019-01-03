package fm.last.lastfm;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import fm.last.lastfm.data.DataManager;
import fm.last.lastfm.data.network.response.Album;
import fm.last.lastfm.data.network.response.Albummatches;
import fm.last.lastfm.data.network.response.Results;
import fm.last.lastfm.data.network.response.SearchResponse;
import fm.last.lastfm.ui.main.MainContract;
import fm.last.lastfm.ui.main.MainPresenter;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import retrofit2.Response;
import retrofit2.Retrofit;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Rule
    public TestRule testRule = new RxImmediateSchedulerRule();
    @Mock
    public MainContract.View mainView;

    @Mock
    public DataManager dataManager;

    MainContract.Presenter presenter;

    Single<SearchResponse> singleSearchResponseSuccess;

    SearchResponse searchResponse;
    List<Album> albums;
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        presenter = new MainPresenter(dataManager);
        presenter.attach(mainView);
        albums = new ArrayList<>();
        Album album = new Album();
        album.setName("Test Album");
        albums.add(album);
        Albummatches albummatches = new Albummatches();
        albummatches.setAlbum(albums);
        Results results = new Results();
        results.setAlbummatches(albummatches);
        searchResponse = new SearchResponse();
        searchResponse.setResults(results);
        singleSearchResponseSuccess = Single.create(new SingleOnSubscribe<SearchResponse>() {
            @Override
            public void subscribe(SingleEmitter<SearchResponse> emitter) throws Exception {
                emitter.onSuccess(searchResponse);
            }
        });
    }
    @Test
    public void testSearchSuccess(){
        when(dataManager.searchAlbum(anyString())).thenReturn(singleSearchResponseSuccess);
        presenter.loadData("abc");
        verify(mainView).displayData(albums);
    }

    /*@Test
    public void testSearchForbidden(){
        when(dataManager.searchAlbum(anyString())).thenReturn();
        presenter.loadData("abc");
        verify(mainView).displayData(albums);
    }*/
}

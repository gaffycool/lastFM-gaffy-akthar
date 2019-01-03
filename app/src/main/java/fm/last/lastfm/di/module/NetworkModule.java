package fm.last.lastfm.di.module;

import dagger.Module;
import dagger.Provides;
import fm.last.lastfm.Constant;
import fm.last.lastfm.data.network.RestApiHelper;
import fm.last.lastfm.data.network.WebServices;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    HttpLoggingInterceptor provideInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor interceptor){
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    @Provides
    GsonConverterFactory provideGsonConverterFactory(){
        return GsonConverterFactory.create();
    }

    @Provides
    Retrofit provideRetrofit(OkHttpClient client, GsonConverterFactory converterFactory){
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(converterFactory)
                .client(client)
                .build();
    }
    @Provides
    WebServices provideWebServices(Retrofit retrofit){
        return retrofit.create(WebServices.class);
    }
    @Provides
    RestApiHelper provideRestApiHelper(WebServices webServices){
        return new RestApiHelper(webServices);
    }
}

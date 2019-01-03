package fm.last.lastfm.di.module;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import fm.last.lastfm.Constant;
import fm.last.lastfm.data.network.RestApiHelper;
import fm.last.lastfm.data.network.WebServices;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    HttpLoggingInterceptor provideHttpLoggingInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    Interceptor provideInterceptor(){
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request newRequest = request.newBuilder().url(request.url()+"&api_key="+Constant.API_KEY)
                        .build();
                return chain.proceed(newRequest);
            }
        };
    }
    @Provides
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor interceptor, Interceptor requestInterceptor){
        return new OkHttpClient.Builder().addInterceptor(interceptor)
                .addInterceptor(requestInterceptor).build();
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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }
    @Provides
    WebServices provideWebServices(Retrofit retrofit){
        return retrofit.create(WebServices.class);
    }
    @Provides
    public RestApiHelper provideRestApiHelper(WebServices webServices){
        return new RestApiHelper(webServices);
    }
}

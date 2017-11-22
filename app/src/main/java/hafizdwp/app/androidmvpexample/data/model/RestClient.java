package hafizdwp.app.androidmvpexample.data.model;

import hafizdwp.app.androidmvpexample.Constant;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Asus on 11/21/2017.
 */

public class RestClient {

    private ApiService apiService;
    private static RestClient instance = null;

    public static RestClient getInstance(){
        if (instance == null)
            instance = new RestClient();
        return instance;
    }

    public ApiService getApiService(){
        return apiService;
    }

    private RestClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .client()
                .build();

        apiService = retrofit.create(ApiService.class);
    }
}

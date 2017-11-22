package hafizdwp.app.androidmvpexample.data.model;

import hafizdwp.app.androidmvpexample.data.pojo.ApiGithubPojo;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Asus on 11/21/2017.
 */

public interface ApiService {

    @GET("{username}")
    Observable<ApiGithubPojo> getDataFromApi(@Path("username") String username);
}

package hafizdwp.app.androidmvpexample.data;


import hafizdwp.app.androidmvpexample.data.model.ApiService;
import hafizdwp.app.androidmvpexample.data.pojo.ApiGithubPojo;
import rx.Observable;

/**
 * Created by Asus on 11/21/2017.
 */

public class DataManager {

    private ApiService apiService;

    public DataManager(ApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<ApiGithubPojo> getDataFromApi(String username) {
        return apiService.getDataFromApi(username);
    }

}

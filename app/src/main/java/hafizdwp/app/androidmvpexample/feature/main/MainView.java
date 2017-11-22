package hafizdwp.app.androidmvpexample.feature.main;

import hafizdwp.app.androidmvpexample.data.pojo.ApiGithubPojo;
import hafizdwp.app.androidmvpexample.feature.base.MvpView;

/**
 * Created by Asus on 11/21/2017.
 */

public interface MainView extends MvpView {
    void onRequestApiSuccess(ApiGithubPojo apiPojo);
}

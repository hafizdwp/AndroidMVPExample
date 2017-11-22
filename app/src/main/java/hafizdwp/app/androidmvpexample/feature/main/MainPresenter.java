package hafizdwp.app.androidmvpexample.feature.main;

import android.util.Log;

import hafizdwp.app.androidmvpexample.data.DataManager;
import hafizdwp.app.androidmvpexample.NetworkError;
import hafizdwp.app.androidmvpexample.data.pojo.ApiGithubPojo;
import hafizdwp.app.androidmvpexample.feature.base.BasePresenter;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Asus on 11/21/2017.
 */

public class MainPresenter extends BasePresenter<MainView> {

    private static final String TAG = "MainPresenter";

    private DataManager dataManager;
    private Subscription subscription;

    public MainPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    void requestApi(String username) {
        if(!isViewAttached()) return;
        /* you can use checkViewAttached() too*/

        getMvpView().showLoading(true);
        subscription = dataManager.getDataFromApi(username)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<ApiGithubPojo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.toString());

                        getMvpView().showLoading(false);
                        getMvpView().showError(new NetworkError(e).getAppErrorMessage());
                    }

                    @Override
                    public void onNext(ApiGithubPojo apiPojo) {
                        getMvpView().showLoading(false);
                        getMvpView().onRequestApiSuccess(apiPojo);
                    }
                });
    }

    @Override
    public void detachView() {
        super.detachView();
        if(!subscription.isUnsubscribed()) subscription.unsubscribe();
    }
}

package hafizdwp.app.androidmvpexample.feature.base;

/**
 * Created by Asus on 11/21/2017.
 */

public interface MvpView {
    void showLoading(boolean isShow);
    void showError(String errorMessage);
    /** you may change these method depend on your need. **/
}

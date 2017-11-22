package hafizdwp.app.androidmvpexample.feature.base;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Asus on 11/21/2017.
 */

public interface Presenter<T extends MvpView> {
    void attachView(@NotNull T mvpView);

    void detachView();
}
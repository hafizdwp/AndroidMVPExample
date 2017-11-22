package hafizdwp.app.androidmvpexample.feature.base;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Asus on 11/21/2017.
 */

public class BasePresenter<T extends MvpView> implements Presenter<T> {

    @Nullable
    private T mvpView;

    @Nullable
    public final T getMvpView() {
        return this.mvpView;
    }

    @Override
    public void attachView(@NotNull T mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void detachView() {
        this.mvpView = null;
    }

    public boolean isViewAttached() {
        return this.mvpView != null;
    }

    public final void checkViewAttached() throws Throwable {
        if(!this.isViewAttached()) {
            throw new MvpViewNotAttachedException();
        }
    }

    public static final class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before requesting listData to the Presenter");
        }
    }
}

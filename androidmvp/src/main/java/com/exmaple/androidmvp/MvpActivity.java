package com.exmaple.androidmvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Base class to all MVP adhering activities
 *
 * @param <P> type of Presenter class
 * @param <V> type of presenter-view class for binding the presenter whenever created/restored
 */
public abstract class MvpActivity<P extends MvpPresenter<V>, V extends MvpView> extends
        AppCompatActivity {
    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = (P) getLastCustomNonConfigurationInstance();
        if (presenter == null) {
            presenter = getPresenterFactory().create();
        }
        presenter.attach((V) this);
        onPresenterCreatedOrRestored(presenter);
    }

    /**
     * Method will be invoked whenever the presenter is created for the first time or was
     * restored when there was a configuration change
     *
     * @param presenter the newly-created/previously-restored presenter
     */
    protected abstract void onPresenterCreatedOrRestored(P presenter);

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return presenter;
    }

    public P getPresenter() {
        return presenter;
    }

    /**
     * A instance of {@link PresenterFactory} that defines the presenter creation for the
     * subclasses.
     */
    public abstract PresenterFactory<P> getPresenterFactory();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}

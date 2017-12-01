package com.exmaple.androidmvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * @param <P> type of Presenter class
 * @param <V> type of presenter-view class for binding the presenter whenever created/restored
 */
public abstract class MvpFragment<P extends MvpPresenter<V>, V extends MvpView> extends Fragment {
    private P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

    public P getPresenter() {
        return presenter;
    }

    /**
     * A instance of {@link PresenterFactory} that defines the presenter creation for the
     * subclasses.
     */
    public abstract PresenterFactory<P> getPresenterFactory();

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}

package com.exmaple.androidmvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * An abstract {@link BaseActivity} implementation which saves the presenter across configuration
 * change i.e. orientation.
 *
 * @param <P> type of Presenter class
 * @param <V> type of presenter-view class for binding the presenter whenever created/restored
 */
public abstract class MvpActivity<P extends MvpPresenter<V>, V> extends AppCompatActivity {
    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}

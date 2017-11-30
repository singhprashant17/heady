package com.exmaple.androidmvp;

/**
 * Creates a Presenter object on demand.
 *
 * @param <P> presenter type
 */
public interface PresenterFactory<P extends MvpPresenter> {
    P create();
}
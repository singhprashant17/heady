package com.exmaple.androidmvp;

/**
 * This view interface myst be implemented for those who perform
 * background/long-running-task/UI-blocking-task and wish to indicate their task status.
 */
public interface MvpLoadingView extends MvpView {

    /**
     * This method indicates that some task is started.
     *
     * @param message loading message
     */
    void startLoading(String message);

    /**
     * This method indicates that some task is stopped.
     */
    void stopLoading();
}

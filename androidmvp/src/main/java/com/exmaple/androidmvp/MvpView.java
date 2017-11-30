package com.exmaple.androidmvp;

import android.content.Context;

/**
 * The main view. All view implementation must implement this interface.
 */
public interface MvpView {
    /**
     * @return the current context (ex. Activity, Fragment)
     */
    Context getContext();

    /**
     * This method is used to indicate any error/success messages that comes during the process
     *
     * @param msg Error string message
     */
    void showMessage(String msg);
}

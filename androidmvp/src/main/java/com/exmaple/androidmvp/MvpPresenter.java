package com.exmaple.androidmvp;

/**
 * The main Presenter. All presenter implementation must implement this interface.
 *
 * @param <V> The view interface from underlying activity of fragment.
 */
public interface MvpPresenter<V> {
    /**
     * This method represents the start of a contract with the view.
     * Mimics the onCreate() and/or onCreateView of Activity or Fragment.
     *
     * @param view The instance of the view interface
     */
    void attach(V view);

    /**
     * This method represents the end of a contract with the view.
     * Mimics the onDestroy() and/or onDestroyView of Activity or Fragment.
     */
    void detach();
}

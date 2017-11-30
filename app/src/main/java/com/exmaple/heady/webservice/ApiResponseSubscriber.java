package com.exmaple.heady.webservice;

import android.util.Log;

import com.exmaple.heady.ApplicationClass;
import com.exmaple.heady.R;
import com.exmaple.heady.utility.Utility;

import rx.SingleSubscriber;

/**
 * Utility class for extracting the error-json from the error.
 */
public class ApiResponseSubscriber<T> extends SingleSubscriber<T> {
    public static final String TAG = ApiResponseSubscriber.class.getSimpleName();

    @Override
    public void onSuccess(T t) {
        Log.d(TAG, "onSuccess: ");
    }

    @Override
    public void onError(Throwable error) {
        Log.d(TAG, "onError: ");
        error.printStackTrace();
        if (error instanceof NoInternetException) {
            Utility.displayToast(ApplicationClass.getInstance()
                    .getString(R.string.no_internet_msg));
        }
    }
}

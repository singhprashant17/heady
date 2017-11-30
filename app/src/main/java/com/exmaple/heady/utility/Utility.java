package com.exmaple.heady.utility;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.exmaple.heady.ApplicationClass;

public class Utility {
    private static final String TAG = Utility.class.getSimpleName();

    /**
     * Method to display a {@link Toast}
     *
     * @param text Message to be displayed;
     */
    public static void displayToast(String text) {
        if (!ValidateData.isNotNullOrBlank(text)) {
            return;
        }
        final Toast toast = Toast.makeText(ApplicationClass.getInstance(), text,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * Method to return a basic {@link ProgressDialog}
     *
     * @param context A valid instance of {@link Context}
     * @return instance of ProgressDialog
     */
    public static ProgressDialog getProgressDialog(Context context) {
        return new ProgressDialog(context);
    }


    /**
     * Method to check network availability
     */
    public static boolean checkNetwork() {
        final Context ctx = ApplicationClass.getInstance();
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context
                .CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnected();
    }
}

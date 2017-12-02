package com.exmaple.heady.utility;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.widget.Toast;

import com.exmaple.heady.ApplicationClass;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

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

    public static String readFromAssets(Context context, String fileName) {
        if (null == context || TextUtils.isEmpty(fileName)) {
            return null;
        }
        try {
            final InputStream inputStream = context.getAssets().open(fileName);
            final int size = inputStream.available();
            final byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            return new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T readFromAssets(Context context, String filename, Class<T> clazz) {
        final String jsonString = readFromAssets(context, filename);
        if (null == jsonString) {
            return null;
        }
        return new Gson().fromJson(jsonString, clazz);
    }
}

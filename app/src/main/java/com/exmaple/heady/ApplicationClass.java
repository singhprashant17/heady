package com.exmaple.heady;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;

public class ApplicationClass extends Application {
    private static ApplicationClass instance;

    public static synchronized Context getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Realm.init(this);
    }
}

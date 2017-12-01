package com.exmaple.heady;

import android.app.Application;
import android.content.Context;

import com.exmaple.heady.di.AppModule;
import com.exmaple.heady.di.DaggerNetComponent;
import com.exmaple.heady.di.NetComponent;
import com.exmaple.heady.di.NetModule;

import io.realm.Realm;

public class ApplicationClass extends Application {
    private static ApplicationClass instance;
    private NetComponent mNetComponent;

    public static synchronized Context getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Realm.init(this);

        mNetComponent = DaggerNetComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(this)) // This also corresponds to the name of your
                // module: %component_name%Module
                .netModule(new NetModule(BuildConfig.BASE_URL))
                .build();
    }
}
